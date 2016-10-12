package br.com.casadocodigo.loja.managedbeans.admin;

import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;
import javax.servlet.http.Part;
import javax.transaction.Transactional;

import br.com.casadocodigo.loja.daos.BookDAO;
import br.com.casadocodigo.loja.infra.FileSaver;
import br.com.casadocodigo.loja.infra.MessagesHelper;
import br.com.casadocodigo.loja.models.Book;

@Model
public class AdminBooksBean {

	private Book product = new Book();
	@Inject
	private BookDAO productDAO;
	@Inject
	private MessagesHelper messagesHelper;
	private Part summary;
	private Part cover;
	@Inject
	private FileSaver fileSaver;

	public void setSummary(Part cover) {
		this.summary = cover;
	}

	public Part getSummary() {
		return summary;
	}

	public Part getCover() {
		return cover;
	}

	public void setCover(Part cover) {
		this.cover = cover;
	}

	@Transactional
	public String save() {
		String summaryPath = fileSaver.write("summaries", summary);
		String coverPath = fileSaver.write("covers", cover);

		product.setSummaryPath(summaryPath);
		product.setCoverPath(coverPath);
		productDAO.save(product);

		messagesHelper.addFlash(new FacesMessage("Livro gravado com sucesso"));
		return "/admin/livros/list?faces-redirect=true";
	}
	
	@Transactional
	public String update(Integer id) {
		//apenas para forcar updates nos livros
		Book book = productDAO.findById(id);
		book.setDescription(book.getDescription() + "- atualizando");
		return "/admin/livros/list?faces-redirect=true";
	}

	public Book getProduct() {
		return product;
	}

}
