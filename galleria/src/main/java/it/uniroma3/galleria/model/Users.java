package it.uniroma3.galleria.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



@Entity
public class Users {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@NotNull
	@Size(min=1)
	@Column (unique=true)
	private String username;
	@NotNull
	@Size(min=1)
	private String password;
	private boolean enabled;
	@OneToOne
	private Authorities auth;
	
	public Users(){
		
	}
	
	public Users(String username,String password,Authorities auth){
		this.username=username;
		this.password=password;
		this.enabled=true;
		this.auth=auth;
	}
	
	public Authorities getAuth() {
		return auth;
	}
	
	public void setAuth(Authorities auth) {
		this.auth = auth;
	}
	
	public boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Long getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	/*privati?!*/
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
