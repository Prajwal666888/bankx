package com.suntech.utils;

import com.suntech.domain.AccountType;

public class AccountTypeUtils {

	public static AccountType createAccountType() {
		AccountType accountType = new AccountType();
		accountType.setTransactionLimit(5000.00);
		accountType.setDepositAmount(4000.00);
		accountType.setWithdrawlLimit(6000.00);
		accountType.setInterestRate(25.00);
		return accountType;
	}

	public static AccountType changeAccountType(AccountType accountType) {
		accountType.setTransactionLimit(5000.00);
		accountType.setDepositAmount(4000.00);
		accountType.setWithdrawlLimit(6000.00);
		accountType.setInterestRate(25.00);
		return accountType;
	}
}
