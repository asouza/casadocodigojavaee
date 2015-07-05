package br.com.casadocodigo.resources;

import java.math.BigDecimal;
import java.net.URI;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.jms.Destination;
import javax.jms.JMSContext;
import javax.servlet.ServletContext;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import br.com.casadocodigo.daos.CheckoutDAO;
import br.com.casadocodigo.models.BroadcastCheckout;
import br.com.casadocodigo.models.Checkout;
import br.com.casadocodigo.models.PaymentGateway;

@Path("payment")
public class PaymentResource {

	private ExecutorService executor = Executors.newFixedThreadPool(50);
	@Context
	private ServletContext ctx;
	@Inject
	private CheckoutDAO checkoutDao;
	@Inject
	private PaymentGateway paymentGateway;
	@Inject
	private BroadcastCheckout broadcastCheckout;
	

	@GET
	public void pay(@Suspended final AsyncResponse ar,@QueryParam("uuid") String uuid) {
		String contextPath = ctx.getContextPath();
		Checkout checkout = checkoutDao.findByUuid(uuid);
		
		executor.submit(() -> {
			
			BigDecimal total = checkout.getValue();

			try {
				paymentGateway.pay(total);
				
				broadcastCheckout.execute(checkout);

				URI redirectURI = UriBuilder
						.fromUri(contextPath + "/site/index.xhtml")
						.queryParam("msg", "Compra realizada com sucesso")
						.build();

				Response response = Response.seeOther(redirectURI).build();
				ar.resume(response);

			} catch (Exception exception) {
				ar.resume(exception);
			}
		});
	}
}
