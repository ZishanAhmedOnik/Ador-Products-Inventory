package com.onik.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Created by onik on 1/7/17.
 */

@Entity
@Table(name = "OUTLET")
public class Outlet {
	@Id
	@GeneratedValue
	private Long OUTLET_ID;

	@OneToMany(targetEntity = Stock.class, mappedBy = "outlet")
	private Collection<Stock> stocks;

	@Column(name = "OUTLET_NAME")
	private String OUTLET_NAME;

	@Column(name = "isDeleted")
	private boolean isDeleted;

	public Outlet() {
	}

	public Outlet(String OUTLET_NAME, boolean isDeleted) {
		this.OUTLET_NAME = OUTLET_NAME;
		this.isDeleted = isDeleted;
	}

	public Long getOUTLET_ID() {
		return OUTLET_ID;
	}

	public void setOUTLET_ID(Long OUTLET_ID) {
		this.OUTLET_ID = OUTLET_ID;
	}

	public String getOUTLET_NAME() {
		return OUTLET_NAME;
	}

	public void setOUTLET_NAME(String OUTLET_NAME) {
		this.OUTLET_NAME = OUTLET_NAME;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean deleted) {
		isDeleted = deleted;
	}

	@Override
	public String toString() {
		return "Outlet [OUTLET_ID=" + OUTLET_ID + ", OUTLET_NAME=" + OUTLET_NAME + ", isDeleted=" + isDeleted + "]";
	}

}
