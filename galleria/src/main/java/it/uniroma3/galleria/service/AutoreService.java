package it.uniroma3.galleria.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.galleria.model.Autore;
import it.uniroma3.galleria.repository.AutoreRepository;

@Service
public class AutoreService {
	
	@Autowired
	private AutoreRepository cr;
	
	public Iterable<Autore> findAll(){
		return this.cr.findAll();
	}
	
	@Transactional
	public void add(final Autore a){
		this.cr.save(a);
	}

	public Autore findById(Long id) {
		return this.cr.findOne(id);
	}
}
