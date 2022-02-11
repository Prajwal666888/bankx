package com.suntech.utils;

import com.suntech.domain.Bank;

public class BankUtils {

	public static Bank createBank() {
		Bank b = new Bank();
		b.setName("Federal Bank");
		b.setType("Savings");
		b.setHead_office("USA");
		return b;
	}

	public static Bank changeBank(Bank b) {
		b.setName("NYFB");
		b.setType("SB");
		b.setHead_office("UK");
		return b;

	}

}
