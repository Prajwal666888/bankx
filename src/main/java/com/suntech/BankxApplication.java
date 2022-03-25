package com.suntech;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;


import com.suntech.service.AccountService;
import com.suntech.service.AccountTypeService;
import com.suntech.service.BankService;
import com.suntech.service.BranchService;


@SpringBootApplication
@EnableScheduling
@EnableJms
@EnableWebSecurity
public class BankxApplication {
	
	@Autowired
	private BranchService branchService;
	
	@Autowired
	private BankService bankService;
	
	@Autowired
	private AccountTypeService accountTypeService;

	public static void main(String[] args) {
		SpringApplication.run(BankxApplication.class, args);
	}
	
	@EventListener(ApplicationReadyEvent.class)
	private  void checkExistingDatas() {
		branchService.createAndSaveBranches();
		bankService.createAndSaveBank();
		accountTypeService.createAndSaveAccountType();
	}
	

}

