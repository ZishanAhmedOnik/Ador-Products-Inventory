package com.onik.entity;

import java.util.Collection;
import java.util.Date;

public class InvoiceEntry {
	private Long outletID;
	private Date invoiceDate;
	private Collection<InvoicedProductEntry> invoicedProductEntries;

	public InvoiceEntry() {

	}

	public Long getOutletID() {
		return outletID;
	}

	public void setOutletID(Long outletID) {
		this.outletID = outletID;
	}

	public Date getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public Collection<InvoicedProductEntry> getInvoicedProductEntries() {
		return invoicedProductEntries;
	}

	public void setInvoicedProductEntries(Collection<InvoicedProductEntry> invoicedProductEntries) {
		this.invoicedProductEntries = invoicedProductEntries;
	}

}
