package com.suntech.utils;

import com.suntech.domain.AccountType;

public class AccountTypeUtils {

	public static AccountType createAccountType() {
		AccountType accountType = new AccountType();
		accountType.setTransactionlimit(5000.00);
		accountType.setDepositamt(4000.00);
		accountType.setWithdrawllimit(6000.00);
		accountType.setInterestrate(25.00);
		return accountType;
	}

	public static AccountType changeAccountType(AccountType accountType) {
		accountType.setTransactionlimit(5100.00);
		accountType.setDepositamt(4100.00);
		accountType.setWithdrawllimit(6100.00);
		accountType.setInterestrate(26.00);
		return accountType;
	}
}
