package br.com.casadocodigo.managedbeans.site;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import br.com.casadocodigo.daos.BookDAO;
import br.com.casadocodigo.models.Book;
import br.com.casadocodigo.models.ShoppingCart;
import br.com.casadocodigo.models.ShoppingItem;

@Model
public class ShoppingCartBean {

	@Inject
	private ShoppingCart shoppingCart;
	@Inject
	private BookDAO bookDAO;
	
	public String add(Integer id){
		Book book = bookDAO.findById(id);
		ShoppingItem item = new ShoppingItem(book);
		shoppingCart.add(item);
		return "/site/carrinho?faces-redirect=true";
	}
	
	public String remove(Integer id){
		Book book = bookDAO.findById(id);
		ShoppingItem item = new ShoppingItem(book);
		shoppingCart.remove(item);
		return "/site/carrinho?faces-redirect=true";
	}
}
