import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import java.util.List;

import javax.persistence.*;

@Entity
public class OnetoX {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(nullable=false)
	private String nome,cognome;
	@OneToOne
	private XtoOne rif1a1;
	@OneToMany
	@JoinColumn(name="unoamonti")
	private List<xtoMany> unoamolti;
	
}
