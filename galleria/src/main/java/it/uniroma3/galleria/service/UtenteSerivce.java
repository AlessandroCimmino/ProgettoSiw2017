package it.uniroma3.galleria.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.galleria.model.Users;
import it.uniroma3.galleria.repository.UtenteRepository;

@Service
public class UtenteSerivce {
	
	@Autowired
	private UtenteRepository cr;
	
	public Iterable<Users> findAll(){
		return this.cr.findAll();
	}
	
	@Transactional
	public void add(final Users a){
		this.cr.save(a);
	}
}
