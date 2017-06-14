package it.uniroma3.galleria.repository;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.galleria.model.Autore;

public interface AutoreRepository extends CrudRepository<Autore,Long>{

	public Autore findByCognome(String cognome);
}
