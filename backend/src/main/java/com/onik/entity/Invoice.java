package com.onik.entity;

import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
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
@Table(name = "INVOICE")
public class Invoice {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "INVOICE_ID")
	private Long ID;

	@Column(name = "INVOICE_DATE")
	private Date date;

	@OneToOne
	@JoinColumn(name = "OUTLET_ID", referencedColumnName = "OUTLET_ID")
	private Outlet outlet;

	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name = "INVOICE_ID", referencedColumnName = "INVOICE_ID")
	private Collection<InvoiceDetails> invoiceDetailsCollection;

	public Invoice() {

	}

	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Outlet getOutlet() {
		return outlet;
	}

	public void setOutlet(Outlet outlet) {
		this.outlet = outlet;
	}

	public Collection<InvoiceDetails> getInvoiceDetailsCollection() {
		return invoiceDetailsCollection;
	}

	public void setInvoiceDetailsCollection(Collection<InvoiceDetails> invoiceDetailsCollection) {
		this.invoiceDetailsCollection = invoiceDetailsCollection;
	}

	@Override
	public String toString() {
		return "Invoice [ID=" + ID + ", date=" + date + ", outlet=" + outlet + ", invoiceDetailsCollection="
				+ invoiceDetailsCollection + "]";
	}

}
