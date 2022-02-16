package com.suntech.domain;

import java.sql.Date;
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
 * @author sujay
 *
 */

@Entity
@Table(name = "customer")
public class Customer extends IdDomain {

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "dob", nullable = false)
	private Date dob;

	@Column(name = "address")
	private String address;

	@Column(name = "accountno", nullable = false)
	private Long accountNo;

	@Column(name = "panno", nullable = false)
	private String panNo;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "bank_id")
	private Bank bank;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "employee_id")
	private Employee employee;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "insurance_id")
	private Insurance insurance;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Account> accounts = new ArrayList<Account>();

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	@OneToMany(targetEntity = Card.class, cascade = CascadeType.ALL, mappedBy = "customer")
	private List<Card> cards = new ArrayList<Card>();

	public Customer() {
		super();
	}

	public Customer(String name, Date dob, String address, Long accountNo, String panNo, Bank bank, Employee employee,
			Insurance insurance, List<Account> accounts, List<Card> cards) {
		super();
		this.name = name;
		this.dob = dob;
		this.address = address;
		this.accountNo = accountNo;
		this.panNo = panNo;
		this.bank = bank;
		this.employee = employee;
		this.insurance = insurance;
		this.accounts = accounts;
		this.cards = cards;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(Long accountNo) {
		this.accountNo = accountNo;
	}

	public String getPanNo() {
		return panNo;
	}

	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Insurance getInsurance() {
		return insurance;
	}

	public void setInsurance(Insurance insurance) {
		this.insurance = insurance;
	}

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

}
