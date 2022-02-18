package com.suntech.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee extends IdDomain {

	@Column(name = "name")
	private String name;

	@Column(name = "type")
	private String type;

	@Column(name = "salary")
	private Double salary;

	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "employee")
	private Shareholders shareholders;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "employee", orphanRemoval = true)
	private Customer customer;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "bank_id")
	private Bank bank;

	public Employee() {
		super();
	}

	public Employee(String name, String type, Double salary, Shareholders shareholders, Customer customer, Bank bank) {
		super();
		this.name = name;
		this.type = type;
		this.salary = salary;
		this.shareholders = shareholders;
		this.customer = customer;
		this.bank = bank;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Shareholders getShareholders() {
		return shareholders;
	}

	public void setShareholders(Shareholders shareholders) {
		this.shareholders = shareholders;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

}
