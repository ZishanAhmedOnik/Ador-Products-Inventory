package com.onik.entity;

public class InvoicedProductEntry {
	private String productID;
	private Long quantity;

	public InvoicedProductEntry() {

	}

	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

}
