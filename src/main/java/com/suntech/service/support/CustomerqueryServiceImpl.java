package com.suntech.service.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suntech.dao.CustomerqueryDao;
import com.suntech.domain.CustomerQuery;
import com.suntech.service.CustomerqueryService;

@Service
public class CustomerqueryServiceImpl implements CustomerqueryService{

	
	@Autowired
	private CustomerqueryDao customerqueryDao;
	
	@Override
	public CustomerQuery createAndSaveCustomerquery(CustomerQuery customerQuery) {
		// TODO Auto-generated method stub
		customerqueryDao.save(customerQuery);
		
		return customerQuery;
	}

}