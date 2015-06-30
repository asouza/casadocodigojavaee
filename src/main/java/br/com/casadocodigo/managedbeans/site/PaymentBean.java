package br.com.casadocodigo.managedbeans.site;

import java.math.BigDecimal;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;

import br.com.casadocodigo.models.PaymentData;
import br.com.casadocodigo.models.ShoppingCart;

@Model
public class PaymentBean {

	@Inject
	private ShoppingCart cart;

	public String checkout() {
		BigDecimal total = cart.getTotal();
		String uriToPay = "http://book-payment.herokuapp.com/payment";

		Client client = ClientBuilder.newClient();
		PaymentData paymentData = new PaymentData(total);
		String result = client.target(uriToPay).request()
				.post(Entity.json(paymentData), String.class);

		
		System.out.println(result);
		
		return "/site/pagamento/ok.xhtml?faces-redirect=true";
	}
}
