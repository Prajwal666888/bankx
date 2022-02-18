package com.suntech.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author sandeep
 *
 */
@Entity
@Table(name = "loan")
public class Loans extends IdDomain {

	@Column(name = "amount")
	private Double amount;

	@Column(name = "loantype")
	private String loanType;

	@Column(name = "rateofinterest")
	private Double rateOfInterest;

	@Column(name = "term")
	private String term;

	@OneToOne(mappedBy = "accountType", cascade = CascadeType.ALL)
	@JoinColumn(name = "account_id", referencedColumnName = "id")
	private Account account;

	public Loans() {

	}

	public Loans(Double amount, String loanType, Double rateOfInterest, String term, Account account) {
		super();
		this.amount = amount;
		this.loanType = loanType;
		this.rateOfInterest = rateOfInterest;
		this.term = term;
		this.account = account;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getLoanType() {
		return loanType;
	}

	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}

	public Double getRateOfInterest() {
		return rateOfInterest;
	}

	public void setRateOfInterest(Double rateOfInterest) {
		this.rateOfInterest = rateOfInterest;
	}

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "Loans [amount=" + amount + ", loanType=" + loanType + ", rateOfInterest=" + rateOfInterest + ", term="
				+ term + ", account=" + account + "]";
	}

}
