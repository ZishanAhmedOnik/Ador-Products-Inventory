package com.onik.entity;

public class StockDTO {
	private String PRODUCT_NUMBER;
	private Long OUTLET_ID;
	private long quantity;

	public StockDTO() {
	}

	public String getPRODUCT_NUMBER() {
		return PRODUCT_NUMBER;
	}

	public void setPRODUCT_NUMBER(String pRODUCT_NUMBER) {
		PRODUCT_NUMBER = pRODUCT_NUMBER;
	}

	public Long getOUTLET_ID() {
		return OUTLET_ID;
	}

	public void setOUTLET_ID(Long oUTLET_ID) {
		OUTLET_ID = oUTLET_ID;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

}
