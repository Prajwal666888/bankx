package com.suntech;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.suntech.controller.BankxController;



@SpringBootTest
public class MyListenerTest {
	
	@Autowired
	BankxController opening;
	
	@Test
	public void testSendAndReceive() {
		opening.send("Account opening received");
	}

}
