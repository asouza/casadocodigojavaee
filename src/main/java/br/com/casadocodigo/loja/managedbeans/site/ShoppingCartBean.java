package br.com.casadocodigo.loja.managedbeans.site;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import br.com.casadocodigo.loja.daos.BookDAO;
import br.com.casadocodigo.loja.models.Book;
import br.com.casadocodigo.loja.models.ShoppingCart;
import br.com.casadocodigo.loja.models.ShoppingItem;

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
