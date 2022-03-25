package com.suntech.service;

import java.util.List;

import com.suntech.domain.AccountType;
import com.suntech.domain.Branches;

public interface AccountTypeService {
	
	public AccountType createAndSave(AccountType accountType);
	
	public Branches createAndSave(Branches branch);
	
	public List<AccountType> fetchAll();
	
	public AccountType createAndSaveAccountType();
	
}

