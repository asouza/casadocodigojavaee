package br.com.casadocodigo.managedbeans.site;

import java.math.BigDecimal;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;

import br.com.casadocodigo.models.PaymentData;
import br.com.casadocodigo.models.ShoppingCart;
import br.com.casadocodigo.models.SystemUser;

@Model
public class CheckoutBean {

	@Inject
	private ShoppingCart cart;
	private SystemUser systemUser = new SystemUser();

	public SystemUser getSystemUser() {
		return systemUser;
	}

	public void setSystemUser(SystemUser systemUser) {
		this.systemUser = systemUser;
	}

	public String checkout() {
		BigDecimal total = cart.getTotal();
		String uriToPay = "http://book-payment.herokuapp.com/payment";

		Client client = ClientBuilder.newClient();
		PaymentData paymentData = new PaymentData(total);
		try {
			client.target(uriToPay).request()
					.post(Entity.json(paymentData), String.class);
			return "/site/pagamento/ok.xhtml?faces-redirect=true";
		} catch (ClientErrorException exception) {
			return "/site/pagamento/falha.xhtml?faces-redirect=true";
		}

	}
}
