package com.suntech.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "account_type")
public class AccountType extends IdDomain {

	@Column(name = "transactionlimit")
	private Double transactionLimit;

	@Column(name = "depositamt")
	private Double depositAmount;

	@Column(name = "withdrawllimit")
	private Double withdrawlLimit;

	@Column(name = "interestrate")
	private Double interestRate;
	
	@OneToOne(mappedBy = "accountType", cascade = CascadeType.ALL)
	private Account account;
	
	public AccountType() {

	}

	public AccountType(Double transactionLimit, Double depositAmount, Double withdrawlLimit, Double interestRate
			) {
		super();
		this.transactionLimit = transactionLimit;
		this.depositAmount = depositAmount;
		this.withdrawlLimit = withdrawlLimit;
		this.interestRate = interestRate;
	
	}


	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Double getTransactionLimit() {
		return transactionLimit;
	}

	public void setTransactionLimit(Double transactionLimit) {
		this.transactionLimit = transactionLimit;
	}

	public Double getDepositAmount() {
		return depositAmount;
	}

	public void setDepositAmount(Double depositAmount) {
		this.depositAmount = depositAmount;
	}

	public Double getWithdrawlLimit() {
		return withdrawlLimit;
	}

	public void setWithdrawlLimit(Double withdrawlLimit) {
		this.withdrawlLimit = withdrawlLimit;
	}

	public Double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(Double interestrate) {
		this.interestRate = interestRate;
	}
}
