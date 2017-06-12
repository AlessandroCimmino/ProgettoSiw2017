package it.uniroma3.galleria.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Quadro {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@NotNull
	@Size(min=1)
	private String titolo;
	@NotNull
	@Size(min=1)
	private String anno;
	@NotNull
	@Size(min=1)
	private String tecnica;
	@NotNull
	@Size(min=1)
	private String dimensione;
	@ManyToOne(fetch = FetchType.EAGER)
	private Autore autore;
	
	public Quadro(){
		
	}
	
	public Quadro(String titolo,String anno,String tecnica,String dimensione){
		this.titolo=titolo;
		this.dimensione=dimensione;
		this.anno=anno;
		this.dimensione=dimensione;
	}

	public Long getId() {
		return id;
	}


	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getAnno() {
		return anno;
	}

	public void setAnno(String anno) {
		this.anno = anno;
	}

	public String getTecnica() {
		return tecnica;
	}

	public void setTecnica(String tecnica) {
		this.tecnica = tecnica;
	}

	public String getDimensione() {
		return dimensione;
	}

	public void setDimensione(String dimensione) {
		this.dimensione = dimensione;
	}

	public Autore getAutore() {
		return autore;
	}

	public void setAutore(Autore autore) {
		this.autore = autore;
	}
	
	
	
}