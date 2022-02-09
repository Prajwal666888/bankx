package com.suntech.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Account")
public class Account extends IdDomain {

	@Column(name = "accountno")
	private Long accountno;

	@Column(name = "balance")
	private Double balance;

	@Column(name = "overdraft")
	private Double overdraft;

	public Account() {

	}

	@OneToOne(mappedBy = "Account", cascade = CascadeType.ALL)
	private AccountType accountType;

	@ManyToOne(fetch = FetchType.LAZY)
	private Customer customer;

	@OneToMany(mappedBy = "Account", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Card> card = new ArrayList<Card>();

	public List<Card> getCard() {
		return card;
	}

	public void setCard(List<Card> card) {
		this.card = card;
	}

	public Account(Long accountno, Double balance, Double overdraft) {
		super();
		this.accountno = accountno;
		this.balance = balance;
		this.overdraft = overdraft;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
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
}
