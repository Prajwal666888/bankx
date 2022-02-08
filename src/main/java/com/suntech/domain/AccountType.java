package com.suntech.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="AccountType")
public class AccountType  extends IdDomain {
	
	@Column(name="transactionlimit")
	private Double transactionlimit;
	@Column(name="depositamt")
	private Double depositamt;
	@Column(name="withdrawllimit")
	private Double withdrawllimit;
	@Column(name="interestrate")
	private Double interestrate;
	public Double getTransactionlimit() {
		return transactionlimit;
	}
	public void setTransactionlimit(Double transactionlimit) {
		this.transactionlimit = transactionlimit;
	}
	public Double getDepositamt() {
		return depositamt;
	}
	public void setDepositamt(Double depositamt) {
		this.depositamt = depositamt;
	}
	public Double getWithdrawllimit() {
		return withdrawllimit;
	}
	public void setWithdrawllimit(Double withdrawllimit) {
		this.withdrawllimit = withdrawllimit;
	}
	public Double getInterestrate() {
		return interestrate;
	}
	public void setInterestrate(Double interestrate) {
		this.interestrate = interestrate;
	}
}
	