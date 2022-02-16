package com.suntech.service.support;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suntech.dao.AccountDao;
import com.suntech.domain.Account;
import com.suntech.domain.AccountType;
import com.suntech.domain.Customer;
import com.suntech.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

	
	@Autowired
	private AccountDao accountDao;

	@Override
	public Account createAndSave(AccountType accountType, Customer customer,Account account) {
		if(validateAccount(account)) {
		account.setAccountType(accountType);
		account.setCustomer(customer);
		accountDao.save(account);
		return account;
		}
		System.out.println("Account already exist");
		return null;
	}
	
		
	public Boolean validateAccount(Account account) {
			List<Account> accounts = accountDao.findAll();
			
			for(Account ac:accounts) {
				if(ac.getAccountno()==account.getAccountno()) {
					continue;
				}
			}
			return true;
			
	}
	
	 

}
