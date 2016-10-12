package br.com.casadocodigo.loja.security;

import javax.enterprise.inject.Model;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import br.com.casadocodigo.loja.models.SystemRole;
import br.com.casadocodigo.loja.models.SystemUser;

@Model
public class AdminSystemUserBean {

	private SystemUser systemUser = new SystemUser();
	@PersistenceContext
	private EntityManager entityManager;
	private String rawPassword;

	
	public String getRawPassword() {
		return rawPassword;
	}

	public void setRawPassword(String rawPassword) {
		this.rawPassword = rawPassword;
	}

	public SystemUser getSystemUser() {
		return systemUser;
	}

	public void setSystemUser(SystemUser systemUser) {
		this.systemUser = systemUser;
	}

	@Transactional
	public void save() {
		systemUser.setPassword(PassGenerator.generate(rawPassword));
		systemUser.add(new SystemRole(AllowedRoles.ROLE_ADMIN.name()));
		entityManager.persist(systemUser);
	}

}
