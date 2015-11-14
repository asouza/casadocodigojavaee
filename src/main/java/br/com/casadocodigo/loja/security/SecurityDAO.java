package br.com.casadocodigo.loja.security;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import br.com.casadocodigo.loja.models.SystemUser;

@Component
public class SecurityDAO implements UserDetailsService{

	@PersistenceContext
	private EntityManager em;

	@Override
	public SystemUser loadUserByUsername(String username)
			throws UsernameNotFoundException {
		String jpql = "select u from SystemUser u where u.email = :login";
		List<SystemUser> users = em.createQuery(jpql,SystemUser.class).setParameter("login", username).getResultList();
		if(users.isEmpty()){
			throw new UsernameNotFoundException("O usuario "+username+" não existe");
		}
		return users.get(0);
	}

}
