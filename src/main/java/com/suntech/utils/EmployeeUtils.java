package com.suntech.utils;

import com.suntech.domain.Employee;

public class EmployeeUtils {

	public static Employee createEmployee() {
		Employee employee = new Employee();
		employee.setName("abc");
		employee.setType("sd");
		employee.setSalary(25000.00);
		return employee;
	}

	public static Employee changeEmployee(Employee employee) {
		employee.setName("bcd");
		employee.setType("test");
		employee.setSalary(25000.00);

		return employee;
	}
}
