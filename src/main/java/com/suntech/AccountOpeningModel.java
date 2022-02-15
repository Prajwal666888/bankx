package com.suntech;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.suntech.domain.Account;
import com.suntech.domain.AccountType;
import com.suntech.domain.Branches;
import com.suntech.domain.Customer;

public class AccountOpeningModel {

	@JsonProperty("accountType")
	private AccountType accountType;
	
	@JsonProperty("account")
	private Account account;
	
	@JsonProperty("branches")
	private Branches branches;
	
	@JsonProperty("customer")
	private Customer customer;

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Branches getBranches() {
		return branches;
	}

	public void setBranches(Branches branches) {
		this.branches = branches;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
