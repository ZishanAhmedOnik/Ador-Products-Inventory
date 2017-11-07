package com.onik.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "INVOICE_PRODUCT")
public class InvoiceDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long ID;

	@Column(name = "INVOICE_ID")
	private Long INVOICE_ID;

	@OneToOne
	@JoinColumn(name = "PRODUCT_NUMBER", referencedColumnName = "PRODUCT_NUMBER")
	private Product product;

	@Column(name = "QUANTITY")
	private Long quantity;

	public InvoiceDetails() {

	}

	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public Long getINVOICE_ID() {
		return INVOICE_ID;
	}

	public void setINVOICE_ID(Long iNVOICE_ID) {
		INVOICE_ID = iNVOICE_ID;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "InvoiceDetails [ID=" + ID + ", INVOICE_ID=" + INVOICE_ID + ", product=" + product + ", quantity="
				+ quantity + "]";
	}

}
