package com.suntech.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.suntech.AccountOpeningModel;
import com.suntech.domain.Account;
import com.suntech.domain.AccountType;
import com.suntech.domain.Bank;
import com.suntech.domain.Branches;
import com.suntech.domain.Customer;
import com.suntech.domain.CustomerQuery;
import com.suntech.domain.Employee;
import com.suntech.service.AccountService;
import com.suntech.service.AccountTypeService;
import com.suntech.service.BankService;
import com.suntech.service.BranchService;
import com.suntech.service.CustomerService;
import com.suntech.service.CustomerqueryService;
import com.suntech.service.EmployeeService;

@RestController
@Component
public class BankxController {

	@Autowired
	private BankService bankService;

	@Autowired
	private BranchService branchService;
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private AccountTypeService accountTypeService;
	
	@Autowired
	private CustomerService customerService;

	@Autowired
	private CustomerqueryService customerqueryService;
	
	@Autowired
	private EmployeeService employeeService;

	@Value("${springjms.accountQueue}")
	private String queue;

	@JmsListener(destination = "${springjms.accountQueue}")
	public void receiveFromAccountQueue(String message)

	{
		System.out.println("Message Received===>" + message);

		JSONObject jsonObj = new JSONObject(message);

		Gson gson = new GsonBuilder().setDateFormat("dd-MM-yyyy").create();
		AccountOpeningModel accountOpeningModel = gson.fromJson(message, AccountOpeningModel.class);

		AccountType accountType = accountOpeningModel.getAccountType();
		Branches branch = accountOpeningModel.getBranches();
		Customer customer = accountOpeningModel.getCustomer();
		Account account = accountOpeningModel.getAccount();

		accountTypeService.createAndSave(accountType);
		customerService.createAndSave(customer);
		branchService.createAndSaveBranch(branch);
		accountService.createAndSave(accountType, customer, account);

		System.out.println(jsonObj);

	}

	@JmsListener(destination = "${springjms.customerQueue}")
	public void receiveFromCustomerQueue(String message) {
		System.out.println("Message==>" + message);

		JSONObject jsonObj = new JSONObject(message);
		Gson gson =new Gson();
		CustomerQuery customerQuery = gson.fromJson(message, CustomerQuery.class);
		customerqueryService.createAndSaveCustomerquery(customerQuery);

		System.out.println(jsonObj);
	}

	@PostMapping("/bank")
	public Bank insertBank(@RequestBody() Bank bank) {
		bankService.createAndSaveBank(bank);
		return bank;
	}

	@PostMapping("/branch")
	public Branches insertBranches(@RequestBody() Branches branches) {
		branchService.createAndSaveBranch(branches);
		return branches;
	}
	
//	Employee API
	@PostMapping("/employee")
	public Employee insertEmployee(@RequestBody()Employee employee) {
		employeeService.createandSave(employee);
		return employee;
	}
	
	

}
