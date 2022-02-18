package com.suntech.service.support;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suntech.dao.CustomerDao;
import com.suntech.domain.Customer;
import com.suntech.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;
	
	@Override
	public Customer createAndSave(Customer customer) {
//		if(customerValidation(customer)) {
			customerDao.save(customer);
//		} 
		return customer;
	}
	
//	public boolean customerValidation(Customer customer) {
//		
//		List<Customer> customerList = customerDao.findAll();
//			for(Customer c:customerList) {
//				if(c.getAccountNo()!=customer.getAccountNo()) {
//					return true;
//				}
//			}
//			return false;
//		
//	}

}
