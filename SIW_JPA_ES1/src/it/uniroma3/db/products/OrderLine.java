package it.uniroma3.db.products;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "order_line")
public class OrderLine {

	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;	
	private Float unitPrice;
	private int quantity;
	@ManyToOne
	@JoinColumn(name="orderline_pro")
	private Product p;

	//GET SET
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Float getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Float unitPrice) {
		this.unitPrice = unitPrice;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Product getP() {
		return p;
	}
	public void setP(Product p) {
		this.p = p;
	}
		
}