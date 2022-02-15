package com.suntech.service.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suntech.dao.AccountTypeDao;
import com.suntech.domain.AccountType;
import com.suntech.service.AccountTypeService;

@Service
public class AccountTypeServiceImpl implements AccountTypeService {

	@Autowired 
	private AccountTypeDao accountTypeDao;

	@Override
	public AccountType createAndSave(AccountType accountType) {
		accountTypeDao.save(accountType);
		return accountType;
	}

}
