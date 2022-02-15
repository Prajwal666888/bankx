package com.suntech.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "account")
public class Account extends IdDomain {

	@Column(name = "accountno")
	private Long accountno;

	@Column(name = "balance")
	private Double balance;

	@Column(name = "overdraft")
	private Double overdraft;

	@OneToOne(cascade =  CascadeType.ALL)
	@JoinColumn(name = "account_type_id")
	private AccountType accountType;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="loans_id")
	private Loans loans;

	@OneToMany(targetEntity = Card.class, cascade = CascadeType.ALL, mappedBy = "account")
	private List<Card> cards = new ArrayList<Card>();

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id")
	private Customer customer;

	public Account() {

	}

	public Account(Long accountno, Double balance, Double overdraft, AccountType accountType, Loans loans,
			List<Card> cards, Customer customer) {
		super();
		this.accountno = accountno;
		this.balance = balance;
		this.overdraft = overdraft;
		this.accountType = accountType;
		this.loans = loans;
		this.cards = cards;
		this.customer = customer;
	}

	public Long getAccountno() {
		return accountno;
	}

	public void setAccountno(Long accountno) {
		this.accountno = accountno;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Double getOverdraft() {
		return overdraft;
	}

	public void setOverdraft(Double overdraft) {
		this.overdraft = overdraft;
	}

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	public Loans getLoans() {
		return loans;
	}

	public void setLoans(Loans loans) {
		this.loans = loans;
	}

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	
}
