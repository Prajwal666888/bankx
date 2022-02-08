package com.suntech.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Sachin
 *
 */
@Entity
@Table(name = "Account")
public class Account extends IdDomain {

	@Column(name = "accountno")
	private Long accountNo;

	@Column(name = "balance")
	private Double balance;

	@Column(name = "overdraft")
	private Double overDraft;

	public Account() {
		super();
	}

	public Account(Long accountNo, Double balance, Double overDraft) {
		super();
		this.accountNo = accountNo;
		this.balance = balance;
		this.overDraft = overDraft;
	}

	public Long getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(Long accountNo) {
		this.accountNo = accountNo;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Double getOverDraft() {
		return overDraft;
	}

	public void setOverDraft(Double overDraft) {
		this.overDraft = overDraft;
	}
}
