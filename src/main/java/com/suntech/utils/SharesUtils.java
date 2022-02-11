package com.suntech.utils;

import com.suntech.domain.Shares;

public class SharesUtils {
	
	public static Shares createShares() {
		Shares shares = new Shares();

		shares.setNumber(1234567d);
		shares.setValue(20000d);
		shares.setType("Ordinary share");
		shares.setEquity(1d);
		shares.setPreferrential("Cumulative preference shares");

		return shares;
	}

	public static Shares changeShares(Shares shares) {

		shares.setNumber(1112246d);
		shares.setValue(40000d);
		shares.setType("Preference shares");
		shares.setEquity(2d);
		shares.setPreferrential("Redeemable preference shares");

		return shares;
	}

}
