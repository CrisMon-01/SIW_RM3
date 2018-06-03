package es4;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Versione {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(name="versione")
	private String v;
	@Temporal(TemporalType.DATE)
	private Date anno;
	@OneToMany(mappedBy="versione")
	private List<Auto> macchine;
	@ManyToOne
	private Modello modello;
	@ManyToMany
	private List<Motore> motori;
	
	public void setModello(Modello m) {
		this.modello=m;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
