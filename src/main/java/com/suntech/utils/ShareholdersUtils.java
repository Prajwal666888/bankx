package com.suntech.utils;

import com.suntech.domain.Shareholders;

public class ShareholdersUtils {

	public static Shareholders createShareholders() {
		Shareholders shareholders = new Shareholders();
		shareholders.setName("XYZ");

		return shareholders;
	}

	public static Shareholders changeShareholders(Shareholders shareholders) {

		shareholders.setName("ZZZ");

		return shareholders;
	}

}
