package com.suntech.service.support;

import javax.transaction.Transactional;

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
	@Transactional
	public Customer createAndSave(Customer customer) {
		customerDao.save(customer);
		return customer;
	}

}
