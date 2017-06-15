package it.uniroma3.galleria.security;

import javax.sql.DataSource;

import org.aspectj.weaver.ast.And;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.*;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;


	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource)
		.usersByUsernameQuery("select username,password, enabled from users where username=?")
		.authoritiesByUsernameQuery("select username, role from user_roles where username=?");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests()
//		.antMatchers("/", "/home","/galleria","/cercaOpera").permitAll()
//		.antMatchers("",).hasRole("ADMIN")
////		.anyRequest().authenticated()
//		.and()
//		.formLogin().loginPage("/login").permitAll()
//		.defaultSuccessUrl("/")
//		.and()
//		.logout().permitAll();
//		
//		http.exceptionHandling().accessDeniedPage("/403");
		http.authorizeRequests()
		.antMatchers("/","/home").permitAll()
		.anyRequest().authenticated()
		.and()
		.formLogin().defaultSuccessUrl("/", true);
		
		
		http.exceptionHandling().accessDeniedPage("/403");
	}



}


