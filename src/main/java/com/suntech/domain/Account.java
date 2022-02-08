package com.suntech.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="Account")
public class Account extends IdDomain{
	
	@Column(name="accountno")
	private Long accountno;
	
	@Column(name="balance")
	private Double balance;
	
	@Column(name="overdraft")
	private Double overdraft;
	
	
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
	

	