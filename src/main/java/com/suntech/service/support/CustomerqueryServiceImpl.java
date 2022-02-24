package com.suntech.service.support;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suntech.dao.CustomerqueryDao;
import com.suntech.domain.CustomerQuery;
import com.suntech.service.CustomerqueryService;

@Service
public class CustomerqueryServiceImpl implements CustomerqueryService {

	@Autowired
	private CustomerqueryDao customerqueryDao;

	@Override
	@Transactional
	public CustomerQuery createAndSaveCustomerquery(CustomerQuery customerQuery) {
		customerqueryDao.save(customerQuery);
		return customerQuery;
	}

}