package br.com.casadocodigo.managedbeans.admin;

import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;
import javax.servlet.http.Part;
import javax.transaction.Transactional;

import br.com.casadocodigo.daos.BookDAO;
import br.com.casadocodigo.infra.FileSaver;
import br.com.casadocodigo.infra.MessagesHelper;
import br.com.casadocodigo.models.Book;

@Model
public class AdminBooksBean {
	
	private Book product = new Book();
	@Inject
	private BookDAO productDAO;
	@Inject
	private MessagesHelper messagesHelper;
	private Part summary;
	@Inject
	private FileSaver fileSaver;

	public void setSummary(Part cover) {
		this.summary = cover;
	}
	
	public Part getSummary() {
		return summary;
	}

	@Transactional
	public String save(){
		String coverPath = fileSaver.write("summaries", summary);
		
		product.setSummaryPath(coverPath);		
		productDAO.save(product);
		
		messagesHelper.addFlash(new FacesMessage("Livro gravado com sucesso"));
		return "/livros/list?faces-redirect=true";
	}
	
	public Book getProduct() {
		return product;
	}
	
}
