package it.uniroma3.galleria.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;


	@Override
	 protected void configure(AuthenticationManagerBuilder auth) throws Exception {

	  auth.jdbcAuthentication().dataSource(dataSource)
	  
	  .passwordEncoder(new BCryptPasswordEncoder())
	  .usersByUsernameQuery("SELECT username,password,enabled FROM users where username=?");
	 }
	
	@Override
	protected void configure(final HttpSecurity http) throws Exception {
	    http
	        .formLogin()
	        .loginPage("/login")
	        .defaultSuccessUrl("/gestisciGalleria",true)
	        .failureUrl("/login?loginError")
	      .and()
	        .logout()
	        .logoutSuccessUrl("/login?logout");
	}



}


