package com.suntech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class BankxController {

	@Autowired
	private JmsTemplate jmsTemplate;

	@Value("${springjms.accountQueue}")
	private String queue;

	public void send(String message) {

		jmsTemplate.convertAndSend(queue, message);

	}

	@JmsListener(destination = "${springjms.accountQueue}")
	public void receiveFromAccountQueue(String message) {
		System.out.println("Message Received===>" + message);

	}

}
