package br.com.casadocodigo.loja.managedbeans.admin;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

import br.com.casadocodigo.loja.models.Book;
import br.com.casadocodigo.loja.models.Sale;
import br.com.casadocodigo.loja.websockets.ConnectedUsers;

@Model
public class AdminSalesBean {

	private Sale sale = new Sale();
	@Inject
	private ConnectedUsers connectedUsers;

	@PostConstruct
	private void configure() {
		this.sale.setBook(new Book());
	}

	public String save() {
		connectedUsers.send(sale.toJson());
		return "/admin/promocoes/form.xhtml?faces-redirect=true";
	}

	public Sale getSale() {
		return sale;
	}

	public void setSale(Sale sale) {
		this.sale = sale;
	}

}
