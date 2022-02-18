package com.suntech.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Branch")
public class Branches extends IdDomain {

	@Column(name = "type")
	private String type;

	@Column(name = "location")
	private String location;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "bank_id")
	private Bank bank;

	public Branches() {
		super();
	}

	public Branches(String type, String location, Bank bank) {
		super();
		this.type = type;
		this.location = location;
		this.bank = bank;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

}
