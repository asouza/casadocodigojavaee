package br.com.casadocodigo.resources;

import java.math.BigDecimal;
import java.net.URI;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import br.com.casadocodigo.daos.SystemUserDAO;
import br.com.casadocodigo.models.PaymentData;
import br.com.casadocodigo.models.ShoppingCart;

@Path("payment")
public class PaymentResource {

	private ExecutorService executor = Executors.newFixedThreadPool(50);
	@Inject
	private ShoppingCart cart;
	@Context
	private ServletContext ctx;

	@GET
	public void pay(@Suspended final AsyncResponse ar,@QueryParam("uuid") String uuid) {
		String contextPath = ctx.getContextPath();
		executor.submit(() -> {
			
			BigDecimal total = cart.getTotal();
			String uriToPay = "http://book-payment.herokuapp.com/payment";

			Client client = ClientBuilder.newClient();
			PaymentData paymentData = new PaymentData(total);
			try {
				Entity<PaymentData> json = Entity.json(paymentData);
				client.target(uriToPay).request()
						.post(json, String.class);

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
