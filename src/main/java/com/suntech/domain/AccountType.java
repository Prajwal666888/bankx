package com.suntech.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Sachin
 *
 */
@Entity
@Table(name = "AccountType")
public class AccountType extends IdDomain {

	@Column(name = "transactionlimit")
	private Double transactionLimit;

	@Column(name = "depositamt")
	private Double depositAmt;

	@Column(name = "withdrawllimit")
	private Double withdrawlLimit;

	@Column(name = "interestrate")
	private Double interestRate;

	public AccountType() {
		super();
	}

	public AccountType(Double transactionLimit, Double depositAmt, Double withdrawlLimit, Double interestRate) {
		super();
		this.transactionLimit = transactionLimit;
		this.depositAmt = depositAmt;
		this.withdrawlLimit = withdrawlLimit;
		this.interestRate = interestRate;
	}

	public Double getTransactionLimit() {
		return transactionLimit;
	}

	public void setTransactionLimit(Double transactionLimit) {
		this.transactionLimit = transactionLimit;
	}

	public Double getDepositAmt() {
		return depositAmt;
	}

	public void setDepositAmt(Double depositAmt) {
		this.depositAmt = depositAmt;
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

	public void setInterestRate(Double interestRate) {
		this.interestRate = interestRate;
	}
}
