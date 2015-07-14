package br.com.casadocodigo.security;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

	
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/livros/**").hasRole("ADMIN")
		.antMatchers("/site/**").permitAll()	
		.antMatchers("/services/**").permitAll()
		.anyRequest().authenticated()		
		.and().formLogin()
		.and().csrf().disable();
	}
}
