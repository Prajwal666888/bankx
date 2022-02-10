package com.suntech;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.suntech.controller.CustomerQueries;


@SpringBootTest
public class QueryListenerTest {

	
	@Autowired
	private CustomerQueries producer;
	
	
	@Test
	public void testQuery() {
		producer.sendQuery("Query is being sent by Prajwal and Pavan ");
	
	}
}
