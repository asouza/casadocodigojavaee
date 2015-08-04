package br.com.casadocodigo.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.casadocodigo.models.Author;

public class AuthorDAO {

	@PersistenceContext
	private EntityManager manager;

	public List<Author> list() {
		return manager.createQuery(
				"select a from Author a order by a.name asc", Author.class)
				.getResultList();
	}

}
