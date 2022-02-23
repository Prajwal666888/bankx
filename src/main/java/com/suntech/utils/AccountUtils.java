package com.suntech.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.suntech.dao.AccountDao;
import com.suntech.domain.Account;
import com.suntech.service.AccountService;
import com.suntech.service.support.AccountServiceImpl;


@Component
public class AccountUtils {

	@Autowired
	private  AccountService accountService;

	public static Account createAccount() {
		Account account = new Account();
		account.setAccountNo((long) 412564888);
		account.setBalance(10000.00);
		account.setOverDraft(100.00);
		return account;
	}

	public static Account changeAccount(Account account) {
		account.setAccountNo((long) 412564777);
		account.setBalance(11000.00);
		account.setOverDraft(110.00);
		return account;
	}

	public  Long generateAccountNumber() {
		Account account = accountService.getLatestAccount();
		if (account !=null) {
			return account.getAccountNo() + 1L;
		}
		return 1L;
	}

}
