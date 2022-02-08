package com.suntech.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * @author sandeep
 *
 */
@Entity
@Table(name="loan")
public class Loans extends IdDomain {
	
	@Column(name="amount")
	private Double amount;
	
	@Column(name="loan_type")
	private String loanType;
	
	@Column(name="rate_of_interest")
	private Double rateOfInterest;
	
	@Column(name="term")
	private String term; 
	
	@Column(name="accountno")
	private Long accountNo;

	public Loans() {
		
	}

	public Loans(Double amount, String loanType, Double rateOfInterest, String term, Long accountNo) {
		super();
		this.amount = amount;
		this.loanType = loanType;
		this.rateOfInterest = rateOfInterest;
		this.term = term;
		this.accountNo = accountNo;
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

	public Long getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(Long accountNo) {
		this.accountNo = accountNo;
	}

	
	
	

}
