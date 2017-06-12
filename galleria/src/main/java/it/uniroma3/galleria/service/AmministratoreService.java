package it.uniroma3.galleria.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.galleria.model.Amministratore;
import it.uniroma3.galleria.repository.AmministratoreRepository;;

@Service
public class AmministratoreService {
	
	@Autowired
	private AmministratoreRepository cr;
	
	public Iterable<Amministratore> findAll(){
		return this.cr.findAll();
	}
	
	@Transactional
	public void add(final Amministratore a){
		this.cr.save(a);
	}
}
