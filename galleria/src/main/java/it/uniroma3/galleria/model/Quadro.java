package it.uniroma3.galleria.model;

import java.net.URL;

import javax.persistence.*;
import javax.validation.constraints.Max;
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
	@Max(2017)
	private Integer anno;
	@NotNull
	@Size(min=1)
	private String tecnica;
	@NotNull
	@Size(min=1)
	private String dimensione;
	@NotNull
	@ManyToOne(fetch = FetchType.EAGER)
	private Autore autore;
	
	private URL image;
	
	public Quadro(){
		
	}
	
	public Quadro(String titolo,Integer anno,String tecnica,String dimensione,URL image,Autore autore){
		this.titolo=titolo;
		this.tecnica=tecnica;
		this.anno=anno;
		this.dimensione=dimensione;
		this.image=image;
		this.autore=autore;
	}

	public Long getId() {
		return id;
	}
	

	public URL getImage() {
		return image;
	}

	public void setImage(URL image) {
		this.image = image;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public Integer getAnno() {
		return anno;
	}

	public void setAnno(Integer anno) {
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