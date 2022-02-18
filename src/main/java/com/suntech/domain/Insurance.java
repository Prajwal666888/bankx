package com.suntech.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "insurance")
public class Insurance extends IdDomain {

	@Column(name = "issuing_company")
	private String issuing_company;

	@Column(name = "type")
	private String type;

	@Column(name = "premium_payment")
	private Double premium_payment;

	@Column(name = "term")
	private Integer term;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "insurance")
	private List<Customer> customers = new ArrayList<Customer>();

	public Insurance() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Insurance(String issuing_company, String type, Double premium_payment, Integer term,
			List<Customer> customers) {
		super();
		this.issuing_company = issuing_company;
		this.type = type;
		this.premium_payment = premium_payment;
		this.term = term;
		this.customers = customers;
	}

	public String getIssuing_company() {
		return issuing_company;
	}

	public void setIssuing_company(String issuing_company) {
		this.issuing_company = issuing_company;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Double getPremium_payment() {
		return premium_payment;
	}

	public void setPremium_payment(Double premium_payment) {
		this.premium_payment = premium_payment;
	}

	public Integer getTerm() {
		return term;
	}

	public void setTerm(Integer term) {
		this.term = term;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

}
