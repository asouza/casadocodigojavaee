package br.com.casadocodigo.security;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

@Model
public class CurrentUser {

	@Inject
	private HttpServletRequest request;
	
	public boolean hasRole(String name){
		return request.isUserInRole(name);
	}
}
