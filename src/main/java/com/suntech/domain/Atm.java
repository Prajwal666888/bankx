package com.suntech.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "bank_id")
	private Bank bank;

	public Atm() {
		super();
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
