package com.suntech.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public   class CustomerQueries {
	
	@JmsListener(destination = "${springjms.customerQueue}")
	public void acceptQueries(String query)  {
			System.out.println("Query Received "+query);
	}
		@Autowired
		private JmsTemplate jmsTemp;
		
		@Value("${springjms.customerQueue}")
		private String queue;
		
		public void sendQuery(String message) {
			jmsTemp.convertAndSend(queue,message);
		}
	}




