package br.com.casadocodigo.managedbeans.site;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import br.com.casadocodigo.daos.BookDAO;
import br.com.casadocodigo.models.Book;

@Model
public class ProductDetailBean {

	@Inject
	private BookDAO bookDAO;
	private Book book;
	
	public void setId(Integer id){
		this.book = bookDAO.findById(id);
	}
	
	public Integer getId() {
		return null;
	}
	
	public Book getBook() {
		return book;
	}
}
