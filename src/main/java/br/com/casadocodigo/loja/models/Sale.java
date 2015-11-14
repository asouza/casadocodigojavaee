package br.com.casadocodigo.loja.models;

import javax.json.Json;
import javax.json.JsonObjectBuilder;

public class Sale {

	private String title;
	private Book book;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public String toJson() {
		JsonObjectBuilder sale = Json.createObjectBuilder();
		sale.add("title", this.title)
			.add("bookId", this.book.getId());

		return sale.build().toString();
	}

}
