package com.suntech.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author stephan
 *
 */
@Entity
@Table(name = "shareholders")
public class Shareholders extends IdDomain {

	@Column(name = "name")
	private String name;

	@OneToMany(mappedBy = "shareholders", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Shares> shares = new ArrayList<Shares>();

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "employee_id")
	private Employee employee;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_id")
	private Customer customer;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "bank_id")
	private Bank bank;

	public Shareholders() {
		super();
	}

	public Shareholders(String name, List<Shares> shares, Employee employee, Customer customer, Bank bank) {
		super();
		this.name = name;
		this.shares = shares;
		this.employee = employee;
		this.customer = customer;
		this.bank = bank;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Shares> getShares() {
		return shares;
	}

	public void setShares(List<Shares> shares) {
		this.shares = shares;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
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
