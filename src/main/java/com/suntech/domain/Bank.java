package com.suntech.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Bank")
public class Bank extends IdDomain {
	
	@Column(name="name")
	private String name;
	
	@Column(name="type")
	private String type;
	
	@Column(name="head_office")
	private String head_office;
	
	@OneToMany
	private List<Atm>atm;
	
	public List<Atm> getAtm() {
		return atm;
	}

	public void setAtm(List<Atm> atm) {
		this.atm = atm;
	}

	public List<Employee> getEmp() {
		return emp;
	}

	public void setEmp(List<Employee> emp) {
		this.emp = emp;
	}

	public List<Customer> getCustomer() {
		return customer;
	}

	public void setCustomer(List<Customer> customer) {
		this.customer = customer;
	}

	public List<Shareholders> getSh() {
		return sh;
	}

	public void setSh(List<Shareholders> sh) {
		this.sh = sh;
	}

	@OneToMany
	private List<Employee>emp;
	
	@OneToMany
	private List<Customer>customer;
	
	@OneToMany
	private List<Shareholders>sh;
	
	
	
	public Bank() {
	}

	public Bank(String name, String type, String head_office) {
		super();
		this.name = name;
		this.type = type;
		this.head_office = head_office;
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

	public String getHead_office() {
		return head_office;
	}

	public void setHead_office(String head_office) {
		this.head_office = head_office;
	}
	
	
}
