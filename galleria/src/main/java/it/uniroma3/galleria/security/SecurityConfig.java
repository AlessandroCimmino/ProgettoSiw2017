package it.uniroma3.galleria.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.*;

 
@Configuration
@EnableAutoConfiguration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource; 

	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.jdbcAuthentication().dataSource(this.dataSource)
				
				.usersByUsernameQuery("select username,password,enabled from users where username=?")
				.authoritiesByUsernameQuery("select username,authority from authorities where username=?");
	}
	
	@Override
	protected void configure(final HttpSecurity http) throws Exception {
	    http.authorizeRequests()
	    	.antMatchers("/gestisciGalleria","/confermaCancellazioneQuadro","/inserimentoQuadro","/modificaQuadro","/mostraDatiInserimentoQuadro").hasAuthority("ROLE_ADMIN")
	    	.and()
	        .formLogin()
	        .loginPage("/login")
	        .defaultSuccessUrl("/gestisciGalleria",true)
	        .failureUrl("/login?loginError")
	      .and()
	        .logout()
	        .logoutSuccessUrl("/login?logout");
		
		
	}
}