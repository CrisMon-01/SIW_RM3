import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class XtoOne {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Temporal(TemporalType.DATE)
	private Date data;
	@Temporal(TemporalType.TIMESTAMP)
	private Date timestamp;
	@OneToOne
	private OnetoX perOne;
	@OneToMany
	private List<ManytoX> many;
}
