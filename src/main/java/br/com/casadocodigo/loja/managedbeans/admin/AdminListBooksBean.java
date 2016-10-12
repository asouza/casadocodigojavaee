package br.com.casadocodigo.loja.managedbeans.admin;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

import br.com.casadocodigo.loja.daos.BookDAO;
import br.com.casadocodigo.loja.models.Book;

@Model
public class AdminListBooksBean {

	@Inject
	private BookDAO bookDAO;
	private List<Book> books = new ArrayList<Book>();
	
	@PostConstruct
	private void loadObjects(){
		this.books = bookDAO.list();
	}
	
	public List<Book> getBooks() {
		return books;
	}
	
}
