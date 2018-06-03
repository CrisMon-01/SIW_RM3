package es3;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Orchestra {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String nome;
	@OneToMany(mappedBy="orchestra")
	private List<Orchestrale> orchestrali;
	@ManyToOne
	private Scuola scuola;
	@ManyToMany(mappedBy="orchestre")
	private List<Concerto> concerti;
}
