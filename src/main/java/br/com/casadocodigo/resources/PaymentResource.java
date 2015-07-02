package br.com.casadocodigo.resources;

import java.math.BigDecimal;
import java.net.URI;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import br.com.casadocodigo.models.PaymentData;
import br.com.casadocodigo.models.ShoppingCart;

@Path("payment")
public class PaymentResource {

	private ExecutorService executor = Executors.newFixedThreadPool(50);
	@Inject
	private ShoppingCart cart;
	@Context
	private ServletContext ctx;

	@POST
	@Path("/")
	public void pay(@Suspended final AsyncResponse ar) {
		executor.submit(() -> {

			BigDecimal total = cart.getTotal();
			String uriToPay = "http://book-payment.herokuapp.com/payment";

			Client client = ClientBuilder.newClient();
			PaymentData paymentData = new PaymentData(total);
			try {
				client.target(uriToPay).request()
						.post(Entity.json(paymentData), String.class);

				URI redirectURI = UriBuilder
						.fromUri(ctx.getContextPath() + "/site/index.xhtml")
						.queryParam("msg", "Compra realizada com sucesso")
						.build();

				Response response = Response.seeOther(redirectURI).build();

				ar.resume(response);

			} catch (Exception exception) {
				exception.printStackTrace();
				ar.resume(exception);
			}
		});
	}

}
