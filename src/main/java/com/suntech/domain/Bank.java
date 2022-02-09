package com.suntech.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Bank")
public class Bank extends IdDomain {

	@Column(name = "name")
	private String name;

	@Column(name = "type")
	private String type;

	@Column(name = "head_office")
	private String head_office;

	@OneToMany(targetEntity = Atm.class, cascade = CascadeType.ALL, mappedBy = "bank")
	private List<Atm> atm = new ArrayList<>();

	@OneToMany(targetEntity = Employee.class, cascade = CascadeType.ALL, mappedBy = "bank")
	private List<Employee> employees = new ArrayList<>();

	@OneToMany(targetEntity = Customer.class, cascade = CascadeType.ALL, mappedBy = "bank")
	private List<Customer> customers = new ArrayList<>();

	@OneToMany(targetEntity = Shareholders.class, cascade = CascadeType.ALL, mappedBy = "bank")
	private List<Shareholders> shareHolders = new ArrayList<>();

	@OneToMany(targetEntity = Branches.class, cascade = CascadeType.ALL, mappedBy = "bank")
	private List<Branches> branches = new ArrayList<Branches>();

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

	public List<Atm> getAtm() {
		return atm;
	}

	public void setAtm(List<Atm> atm) {
		this.atm = atm;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public List<Shareholders> getShareHolders() {
		return shareHolders;
	}

	public void setShareHolders(List<Shareholders> shareHolders) {
		this.shareHolders = shareHolders;
	}

	public List<Branches> getBranches() {
		return branches;
	}

	public void setBranches(List<Branches> branches) {
		this.branches = branches;
	}

}
