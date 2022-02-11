package com.suntech.utils;

import com.suntech.domain.Atm;

public class AtmUtils {
	
	public static Atm createAtm() {
		Atm atm = new Atm();
		atm.setLocation("banglore");
		atm.setAmountOfCash(111d);
		return atm;
	}

	public static Atm changeAtm(Atm atm) {
		atm.setLocation("Manglore");
		atm.setAmountOfCash(222d);
		return atm;
	}

}
