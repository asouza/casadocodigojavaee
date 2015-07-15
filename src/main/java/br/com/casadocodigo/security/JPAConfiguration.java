package br.com.casadocodigo.security;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;

import org.springframework.context.annotation.Bean;

public class JPAConfiguration {

	@Bean
	public EntityManagerFactory emf() throws NamingException {
		Context ctx = new InitialContext();
		EntityManagerFactory lookup = (EntityManagerFactory) ctx
				.lookup("java:comp/env/persistence/casadocodigo-emf");
		return lookup;
	}
}
