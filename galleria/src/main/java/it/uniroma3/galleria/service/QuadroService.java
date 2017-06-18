package it.uniroma3.galleria.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.galleria.model.Autore;
import it.uniroma3.galleria.model.Quadro;
import it.uniroma3.galleria.repository.AutoreRepository;
import it.uniroma3.galleria.repository.QuadroRepository;;

@Service
public class QuadroService {

	@Autowired
	private QuadroRepository cr;
	
	@Autowired
	private AutoreRepository ar;

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
	public void aggiorna(String titolo, Integer anno, String tecnica, String dimensione, Autore autore,Quadro quadro) {
		quadro.setAnno(anno);
		quadro.setAutore(autore);
		quadro.setDimensione(dimensione);
		quadro.setTecnica(tecnica);
		quadro.setTitolo(titolo);
		this.cr.save(quadro);	
	}

	public List<Quadro> findAllByCriterio(String chiave, String criterio) {
		if(criterio.equals("Titolo")) 
			return this.cr.findByTitolo(chiave);
		else if(criterio.equals("Autore")) 
			return this.cr.findByAutore(this.ar.findByCognome(chiave));
		else if(criterio.equals("Dimensione"))
			return this.cr.findByDimensione(chiave);
		else if(criterio.equals("Tecnica"))
			return this.cr.findByTecnica(chiave);
		else
			return this.cr.findByAnno(Integer.parseInt(chiave));
	}

	@Transactional
	public void aggiorna(Quadro quadro, Long quadroVecchioId) {
		Quadro quadroDaModificare = this.cr.findOne(quadroVecchioId);
		quadroDaModificare.setAnno(quadro.getAnno());
		quadroDaModificare.setAutore(quadro.getAutore());
		quadroDaModificare.setDimensione(quadro.getDimensione());
		quadroDaModificare.setTecnica(quadro.getTecnica());
		quadroDaModificare.setTitolo(quadro.getTitolo());
		quadroDaModificare.setImage(quadro.getImage());
		this.cr.save(quadroDaModificare);
	}
}
