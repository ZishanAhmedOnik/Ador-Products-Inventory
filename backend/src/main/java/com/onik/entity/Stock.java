package com.onik.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "STOCK")
public class Stock {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long ID;

	@ManyToOne
	@JoinColumn(name = "OUTLET_ID", referencedColumnName = "OUTLET_ID")
	private Outlet outlet;

	@ManyToOne
	@JoinColumn(name = "PRODUCT_NUMBER", referencedColumnName = "PRODUCT_NUMBER")
	private Product product;

	@Column(name = "QUANTITY")
	private long quantity;

	public Stock() {
		this.setQuantity(0);
	}

	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public Outlet getOutlet() {
		return outlet;
	}

	public void setOutlet(Outlet outlet) {
		this.outlet = outlet;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "Stock [ID=" + ID + ", outlet=" + outlet + ", product=" + product + ", quantity=" + quantity + "]";
	}

}
