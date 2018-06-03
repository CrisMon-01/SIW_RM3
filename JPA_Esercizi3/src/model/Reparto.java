package model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Reparto {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(nullable=false)
	private String nome,piano;
	@OneToMany(mappedBy="reparto")
	private List<Prodotto> prodotti;
	@ManyToMany
	@JoinColumn(name="magazzini_prodotti")
	private List<Magazziniere> magazzinieri;
}
