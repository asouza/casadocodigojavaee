package br.com.casadocodigo.daos;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.casadocodigo.models.Book;


public class BookDAO {
	
	@PersistenceContext
	private EntityManager manager;
		
	public void save(Book product) {
		manager.persist(product);
	}

	
}
