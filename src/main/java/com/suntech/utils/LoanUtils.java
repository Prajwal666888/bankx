package com.suntech.utils;

import com.suntech.domain.Loans;

public class LoanUtils {

	public static Loans createLoan() {
		Loans loan = new Loans();
		loan.setAmount(120000d);

		loan.setLoanType("home loan");
		loan.setRateOfInterest(5d);
		loan.setTerm("short");

		return loan;
	}

	public static Loans changeLoan(Loans loan) {
		loan.setAmount(156600d);

		loan.setLoanType("car loan");
		loan.setRateOfInterest(10d);
		loan.setTerm("long");

		return loan;
	}

}
