package br.com.casadocodigo.managedbeans.admin;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.inject.Inject;
import javax.servlet.http.Part;
import javax.transaction.Transactional;

import br.com.casadocodigo.daos.BookDAO;
import br.com.casadocodigo.infra.FileSaver;
import br.com.casadocodigo.infra.MessagesHelper;
import br.com.casadocodigo.models.Author;
import br.com.casadocodigo.models.Book;

@Model
public class AdminBooksBean {
	
	private Book product = new Book();
	@Inject
	private BookDAO productDAO;
	private List<String> selectedAuthorsIds = new ArrayList<>();
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
		
		System.out.println(summary.getName() + ";" 
				+summary.getHeader("content-disposition"));
		
		populateBookAuthor();		
		String coverPath = fileSaver.write("covers", summary);
		
		product.setSummaryPath(coverPath);		
		productDAO.save(product);
		
		messagesHelper.addFlash(new FacesMessage("Livro gravado com sucesso"));
		return "/livros/list?faces-redirect=true";
	}
	
	private void populateBookAuthor() {
		selectedAuthorsIds.stream().map( (strId) -> {
			return new Author(Integer.parseInt(strId));
		}).forEach(product :: add);
	}
	
	public void setSelectedAuthorsIds(List<String> selectedAuthorsIds) {
		this.selectedAuthorsIds = selectedAuthorsIds;
	}
	
	public List<String> getSelectedAuthorsIds() {
		return selectedAuthorsIds;
	}
	
	public Book getProduct() {
		return product;
	}
	
}
