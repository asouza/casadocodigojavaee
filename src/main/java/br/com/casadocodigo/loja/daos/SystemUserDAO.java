package br.com.casadocodigo.loja.daos;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.casadocodigo.loja.models.SystemUser;

public class SystemUserDAO {

	@PersistenceContext
	private EntityManager entityManager;

	public void save(SystemUser systemUser) {
		entityManager.persist(systemUser);
	}

	public SystemUser findByUuid(String uuid) {
		return entityManager
				.createQuery(
						"select su from SystemUser su where su.uuid=:uuid",
						SystemUser.class).setParameter("uuid", uuid)
				.getSingleResult();
	}
}
