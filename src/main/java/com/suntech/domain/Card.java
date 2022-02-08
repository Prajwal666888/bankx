package com.suntech.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;



/**
 * @author stephan
 *
 */
@Entity
@Table(name="card")
public class Card extends IdDomain{

	
	@Column(name="accountno")
	private Long accountNo;
	
	@Column(name="cardno")
	private Long cardNo;
		
	@Column(name="validfrom")
	private String validFrom;
	
	@Column(name="validto")
	private String validTo;

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

	

	
		
}
