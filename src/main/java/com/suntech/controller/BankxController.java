package com.suntech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.suntech.domain.Bank;
import com.suntech.domain.Branches;
import com.suntech.service.BankService;
import com.suntech.service.BranchService;

@RestController
@Component
public class BankxController {

	@Autowired
	private JmsTemplate jmsTemplate;
	@Autowired
	private BankService bankService;
	@Autowired
	private BranchService branchService;

	@Value("${springjms.accountQueue}")
	private String queue;

	public void send(String message) {

		jmsTemplate.convertAndSend(queue, message);

	}

	@JmsListener(destination = "${springjms.accountQueue}")
	public void receiveFromAccountQueue(String message) {
		System.out.println("Message Received===>" + message);

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

}
