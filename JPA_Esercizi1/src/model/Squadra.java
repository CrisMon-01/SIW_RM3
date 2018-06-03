package model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Squadra {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(nullable=false)
	private String nome,nomeAllenatore;
	@Temporal(TemporalType.DATE)
	private Date nascita;
	@OneToMany(mappedBy="squadra")
	private List<Giocatore> giocatori;
	
	//GET SET	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNomeAllenatore() {
		return nomeAllenatore;
	}
	public void setNomeAllenatore(String nomeAllenatore) {
		this.nomeAllenatore = nomeAllenatore;
	}
	public Date getNascita() {
		return nascita;
	}
	public void setNascita(Date nascita) {
		this.nascita = nascita;
	}
	public List<Giocatore> getGiocatori() {
		return giocatori;
	}
	public void setGiocatori(List<Giocatore> giocatori) {
		this.giocatori = giocatori;
	}
}
