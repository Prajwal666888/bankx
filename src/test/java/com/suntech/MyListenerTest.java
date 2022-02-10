package com.suntech;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.suntech.controller.AccountOpening;



@SpringBootTest
public class MyListenerTest {
	
	@Autowired
	AccountOpening opening;
	
	@Test
	public void testSendAndReceive() {
		opening.send("Account opening received");
	}

}
