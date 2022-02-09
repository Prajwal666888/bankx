package com.suntech.utils;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateTimeUtils {

	public static Date getDateIn(String dateFormat, String stringDate) {
		java.util.Date date = null;
		try {
			SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
			date = formatter.parse(stringDate);
			formatter.format(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return new Date(date.getTime());
	}

}
