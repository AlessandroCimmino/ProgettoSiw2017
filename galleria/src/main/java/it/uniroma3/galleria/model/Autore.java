package it.uniroma3.galleria.model;

import java.util.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Autore {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@NotNull
	@Size(min=1)
	private String nome;
	@NotNull
	@Size(min=1)
	private String cognome;
	@NotNull
	@Size(min=1)
	private String nazionalita;
	@Temporal(TemporalType.DATE)
	@NotNull
	private Date dataNascita;
	@Temporal(TemporalType.DATE)
	@NotNull
	private Date dataMorte;
	@OneToMany(mappedBy="autore", fetch = FetchType.EAGER, cascade = {CascadeType.REMOVE})
	private List<Quadro> quadri;
	
	public Autore(){
		this.quadri=new ArrayList<>();
	}

	public Long getId() {
		return id;
	}
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getNazionalita() {
		return nazionalita;
	}

	public void setNazionalita(String nazionalita) {
		this.nazionalita = nazionalita;
	}

	public Date getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}

	public Date getDataMorte() {
		return dataMorte;
	}

	public void setDataMorte(Date dataMorte) {
		this.dataMorte = dataMorte;
	}

	public List<Quadro> getQuadri() {
		return quadri;
	}

	public void setQuadri(List<Quadro> quadri) {
		this.quadri = quadri;
	}
	
	
	
}
