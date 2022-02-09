package com.suntech.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author stephan
 *
 */
@Entity
@Table(name = "card")
public class Card extends IdDomain {

	@Column(name = "accountno")
	private Long accountNo;

	@Column(name = "cardno")
	private Long cardNo;

	@Column(name = "validfrom")
	private String validFrom;

	@Column(name = "validto")
	private String validTo;

	@ManyToOne(fetch = FetchType.LAZY)
	private Account account;

	@ManyToOne(fetch = FetchType.LAZY)
	private Customer customer;

	public Card() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Card(Long accountNo, Long cardNo, String validFrom, String validTo) {
		super();
		this.accountNo = accountNo;
		this.cardNo = cardNo;
		this.validFrom = validFrom;
		this.validTo = validTo;
	}

	public Long getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(Long accountNo) {
		this.accountNo = accountNo;
	}

	public Long getCardNo() {
		return cardNo;
	}

	public void setCardNo(Long cardNo) {
		this.cardNo = cardNo;
	}

	public String getValidFrom() {
		return validFrom;
	}

	public void setValidFrom(String validFrom) {
		this.validFrom = validFrom;
	}

	public String getValidTo() {
		return validTo;
	}

	public void setValidTo(String validTo) {
		this.validTo = validTo;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
