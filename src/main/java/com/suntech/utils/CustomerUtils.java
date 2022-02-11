package com.suntech.utils;

import com.suntech.domain.Customer;

public class CustomerUtils {

	public static Customer createCustomer() {
		Customer customer = new Customer();
		customer.setName("James");
		customer.setAccountNo(1212121212l);
		customer.setPanNo("HS10JB33");
		customer.setDob(DateTimeUtils.getDateIn("dd-mm-yyyy", "20-01-1996"));
		return customer;
	}

	public static Customer changeCustomer(Customer customer) {
		customer.setName("Scott");
		customer.setAccountNo(132132132l);
		customer.setPanNo("PSO3033");
		customer.setDob(DateTimeUtils.getDateIn("dd-mm-yyyy", "20-01-1989"));
		return customer;
	}
}
