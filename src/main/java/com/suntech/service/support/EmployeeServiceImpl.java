package com.suntech.service.support;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suntech.dao.EmployeeDao;
import com.suntech.domain.Employee;
import com.suntech.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeDao emp;

	@Override
	@Transactional
	public Employee createandSave(Employee employee) {
		emp.save(employee);
		return employee;
	}
	
	
}
