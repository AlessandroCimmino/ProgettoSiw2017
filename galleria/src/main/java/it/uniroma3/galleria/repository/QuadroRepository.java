package it.uniroma3.galleria.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.galleria.model.Autore;
import it.uniroma3.galleria.model.Quadro;

public interface QuadroRepository extends CrudRepository<Quadro, Long>{
	
	List<Quadro> findByTitolo(String titolo);

	List<Quadro> findByAutore(Autore autore);

	List<Quadro> findByDimensione(String dimensione);

	List<Quadro> findByTecnica(String tecnica);

	List<Quadro> findByAnno(String anno);
}
