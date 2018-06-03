import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class ManytoX {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Temporal(TemporalType.TIMESTAMP)
	private Date data;
	@Column(nullable= false,unique=true)
	private int matricola;
	@ManyToMany(mappedBy="mtxs")
	private List<xtoMany> xtms;
	@ManyToOne
	private XtoOne xtoo;
	@ManyToMany
	private List<xtoMany> xtmmonodir;
	@ManyToOne
	private XtoOne uno;
}
