package br.com.casadocodigo.daos;

import java.util.List;

import javax.annotation.PreDestroy;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import br.com.casadocodigo.models.Book;

@Stateful
public class BookDAO {

	@PersistenceContext(type=PersistenceContextType.EXTENDED)
	private EntityManager manager;

	public void save(Book product) {
		manager.persist(product);
	}

	public List<Book> list() {
		return manager.createQuery("select b from Book b join fetch b.authors",
				Book.class).getResultList();
	}

	public List<Book> lastReleases() {
		return manager
				.createQuery(
						"select b from Book b where b.releaseDate <= now() order by b.id desc",
						Book.class).setMaxResults(3).getResultList();
	}

	public List<Book> last(int number) {
		return manager.createQuery("select b from Book b join fetch b.authors", Book.class)
				.setMaxResults(number).getResultList();
	}

	public Book findById(Integer id) {
		return manager.find(Book.class,id);
	}
	
	@PreDestroy
	private void removendo(){
		System.out.println("removendo BookDAO");
	}
	
}
