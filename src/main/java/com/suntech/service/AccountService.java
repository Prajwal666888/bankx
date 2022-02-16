package com.suntech.service;

import com.suntech.domain.Account;
import com.suntech.domain.AccountType;
import com.suntech.domain.Customer;

public interface AccountService {
	
	public Account createAndSave(AccountType accountType,Customer customer,Account account);

}
