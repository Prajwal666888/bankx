package com.suntech.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * @author stephan
 *
 */
@Entity
@Table(name="shares")
public class Shares extends IdDomain{
	
	@Column(name="number")
	private Double number;
	
	@Column(name="value")
	private Double value;
	
	@Column(name="type")
	private String type;
	
	@Column(name="equity")
	private Double equity;
	
	@Column(name="preferrential")
	private String preferrential;



	public Shares() {
		super();
	}



	public Shares(Double number, Double value, String type, Double equity, String preferrential) {
		super();
		this.number = number;
		this.value = value;
		this.type = type;
		this.equity = equity;
		this.preferrential = preferrential;
	}



	public Double getNumber() {
		return number;
	}

	public void setNumber(Double number) {
		this.number = number;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Double getEquity() {
		return equity;
	}
	public void setEquity(Double equity) {
		this.equity = equity;
	}
	public String getPreferrential() {
		return preferrential;
	}
	public void setPreferrential(String preferrential) {
		this.preferrential = preferrential;
	}
	
	
}
