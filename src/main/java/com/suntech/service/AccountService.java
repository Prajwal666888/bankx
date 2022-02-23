package com.suntech.service;

import com.suntech.domain.Account;

public interface AccountService {
	
	public Account createAndSave(Account account);
	
	public Account getLatestAccount();

}
