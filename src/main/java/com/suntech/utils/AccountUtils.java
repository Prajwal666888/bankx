package com.suntech.utils;

import com.suntech.domain.Account;

public class AccountUtils {

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
}
