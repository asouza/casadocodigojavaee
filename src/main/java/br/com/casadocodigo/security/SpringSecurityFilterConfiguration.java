package br.com.casadocodigo.security;

import org.springframework.security.web.context.*;

public class SpringSecurityFilterConfiguration extends
		AbstractSecurityWebApplicationInitializer {

	public SpringSecurityFilterConfiguration() {
		super(SecurityConfiguration.class,SystemUserDAO.class);
	}
}
