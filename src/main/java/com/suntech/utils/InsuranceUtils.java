package com.suntech.utils;

import com.suntech.domain.Insurance;

public class InsuranceUtils {

	public static Insurance createInsurance() {
		Insurance i = new Insurance();
		i.setType("LongTerm");
		i.setPremium_payment(560023.23);
		i.setIssuing_company("Tech Mahindra");
		i.setTerm(2);
		return i;
	}

	public static Insurance changeInsurance(Insurance i) {
		i.setIssuing_company("New Oriental");
		i.setPremium_payment(2285658.21);
		i.setTerm(1);
		i.setType("Short Term");
		return i;
	}

}
