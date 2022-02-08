package com.suntech.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author sujay
 *
 */

@Entity
@Table(name = "atm")
public class Atm extends IdDomain {

	@Column(name = "location", nullable = false)
	private String location;

	@Column(name = "amountofcash", nullable = false)
	private Double amountOfCash;

	

	public Atm() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Atm(String location, Double amountOfCash) {
		super();
		this.location = location;
		this.amountOfCash = amountOfCash;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Double getAmountOfCash() {
		return amountOfCash;
	}

	public void setAmountOfCash(Double amountOfCash) {
		this.amountOfCash = amountOfCash;
	}

}
