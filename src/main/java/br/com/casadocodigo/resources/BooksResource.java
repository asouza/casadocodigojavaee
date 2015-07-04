package br.com.casadocodigo.resources;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.annotations.providers.jaxb.Wrapped;

import br.com.casadocodigo.daos.BookDAO;
import br.com.casadocodigo.models.Book;

@Path("books")
public class BooksResource {
	
	@Inject
	private BookDAO bookDAO;

	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@GET
	@Wrapped(element="books")
	public List<Book> lastBooks(){
		return bookDAO.lastReleases();
	}
}
