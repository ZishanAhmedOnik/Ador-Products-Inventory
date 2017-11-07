package com.onik.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Created by onik on 1/7/17.
 */
@Entity
@Table(name = "PRODUCT")
public class Product {
	@Id
	@Column(name = "PRODUCT_NUMBER")
	private String PRODUCT_NUMBER;

	@Column(name = "PRODUCT_NAME")
	private String PRODUCT_NAME;

	@Column(name = "PRICE")
	private double PRICE;

	@Column(name = "isDeleted")
	private boolean isDeleted;

	@OneToMany(targetEntity = Stock.class, mappedBy = "product")
	private Collection<Stock> stocks;

	public Product() {
	}

	public Product(String PRODUCT_NUMBER, String PRODUCT_NAME, double PRICE, boolean isDeleted) {
		this.PRODUCT_NUMBER = PRODUCT_NUMBER;
		this.PRODUCT_NAME = PRODUCT_NAME;
		this.PRICE = PRICE;
		this.isDeleted = isDeleted;
	}

	public String getPRODUCT_NUMBER() {
		return PRODUCT_NUMBER;
	}

	public void setPRODUCT_NUMBER(String PRODUCT_NUMBER) {
		this.PRODUCT_NUMBER = PRODUCT_NUMBER;
	}

	public String getPRODUCT_NAME() {
		return PRODUCT_NAME;
	}

	public void setPRODUCT_NAME(String PRODUCT_NAME) {
		this.PRODUCT_NAME = PRODUCT_NAME;
	}

	public double getPRICE() {
		return PRICE;
	}

	public void setPRICE(double PRICE) {
		this.PRICE = PRICE;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean deleted) {
		isDeleted = deleted;
	}

	@Override
	public String toString() {
		return "Product [PRODUCT_NUMBER=" + PRODUCT_NUMBER + ", PRODUCT_NAME=" + PRODUCT_NAME + ", PRICE=" + PRICE
				+ ", isDeleted=" + isDeleted + "]";
	}

}
