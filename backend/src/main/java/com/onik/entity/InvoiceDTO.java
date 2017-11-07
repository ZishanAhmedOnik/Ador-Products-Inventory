package com.onik.entity;

import java.util.Date;

public class InvoiceDTO {
	private Long ID;
	private String invoiceDate;
	private String outletName;

	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public String getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(String invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public String getOutletName() {
		return outletName;
	}

	public void setOutletName(String outletName) {
		this.outletName = outletName;
	}

}
