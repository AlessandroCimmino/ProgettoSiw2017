package it.uniroma3.galleria.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.galleria.model.Autore;
import it.uniroma3.galleria.model.Quadro;
import it.uniroma3.galleria.repository.QuadroRepository;;

@Service
public class QuadroService {

	@Autowired
	private QuadroRepository cr;

	public Iterable<Quadro> findAll(){
		return this.cr.findAll();
	}

	@Transactional
	public void add(final Quadro a){
		this.cr.save(a);
	}

	public Quadro findById(Long id) {
		return this.cr.findOne(id);
	}

	public void removeById(Long id) {
		this.cr.delete(id);

	}

	@Transactional
	public void aggiorna(String titolo, String anno, String tecnica, String dimensione, Autore autore,Quadro quadro) {
		quadro.setAnno(anno);
		quadro.setAutore(autore);
		quadro.setDimensione(dimensione);
		quadro.setTecnica(tecnica);
		quadro.setTitolo(titolo);
		this.cr.save(quadro);	
	}
}
