package it.uniroma3.db.products;

import java.util.List;
import java.security.Timestamp;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;


@Entity
@Table(uniqueConstraints=@UniqueConstraint(columnNames={"firstname","lastname"}))
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false)
	private String firstName;
	@Column(nullable = false)
	private String lastName;
	private String email;
	@Temporal (TemporalType.DATE)
	private Date dateOfBirth;	//DATE
	@Temporal (TemporalType.TIMESTAMP)
	private Date registrationDate;
	@OneToOne						//RIF A OBJ DEL DB È UN ASSOCIAZ 1 A 1
	private Address addressCustomer;	
	@OneToMany(mappedBy = "customer")
	private List<Order> orders;

	//GET SET
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public Address getAddress() {
		return addressCustomer;
	}
	public void setAddress(Address address) {
		this.addressCustomer = address;
	}

	@Override
	public int hashCode() {
		return this.getEmail().length()+this.getLastName().length();
	}
	@Override
	public boolean equals(Object o) {
		Customer corrente = (Customer)o;
		return this.email.equals(corrente.email)&& this.lastName.equals(corrente.getLastName());
	}
}