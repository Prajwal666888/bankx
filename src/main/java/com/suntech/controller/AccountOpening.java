package com.suntech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class AccountOpening {

	@Autowired
	private JmsTemplate jmsTemplate;
	@Value("${springjms.accountQueue}")
	private String queue;

	public void send(String message) {

		jmsTemplate.convertAndSend(queue, message);

	}
	
	@ComponentScan
	public class MyListener {

		// pojo class
		@JmsListener(destination = "${springjms.accountQueue}")

		public void receive(String message) {
			System.out.println("Message Received===>" + message);

		}

	}

	

}



