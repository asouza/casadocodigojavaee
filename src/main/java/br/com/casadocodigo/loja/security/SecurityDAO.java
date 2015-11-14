package br.com.casadocodigo.loja.security;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.casadocodigo.loja.models.SystemUser;

public class SecurityDAO {

	@PersistenceContext
	private EntityManager em;
	
	public SystemUser loadUserByUsername(String username) {
		String jpql = "select u from SystemUser u where u.email = :login";
		List<SystemUser> users = em.createQuery(jpql,SystemUser.class).setParameter("login", username).getResultList();
		return users.get(0);
	}

}
