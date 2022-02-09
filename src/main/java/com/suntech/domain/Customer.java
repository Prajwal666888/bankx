package com.suntech.domain;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author sujay
 *
 */

@Entity
@Table(name = "customer")
public class Customer extends IdDomain {

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "dob", nullable = false)
	private Date dob;

	@Column(name = "address")
	private String address;

	@Column(name = "accountNo", nullable = false)
	private Long accountNo;

	@Column(name = "panNo", nullable = false)
	private String panNo;

	public Customer() {
		super();
	}

	public Customer(String name, Date dob, String address, Long accountNo, String panNo) {
		super();
		this.name = name;
		this.dob = dob;
		this.address = address;
		this.accountNo = accountNo;
		this.panNo = panNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(Long accountNo) {
		this.accountNo = accountNo;
	}

	public String getPanNo() {
		return panNo;
	}

	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}

}
