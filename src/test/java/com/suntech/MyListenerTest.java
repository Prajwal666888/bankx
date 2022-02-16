package com.suntech;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jms.core.JmsTemplate;

/**
 * @author Sachin
 *
 */
@SpringBootTest
public class MyListenerTest {

	private String accountMessage = "{\r\n" + "\"accountType\":{\r\n" + "	\"transactionlimit\": \"50000\",\r\n"
			+ "	\"depositamt\":\"20000\",\r\n" + "	\"withdrawllimit\":\"49000\",\r\n" + "	\"interestrate\":\"8\"\r\n"
			+ "},\r\n" + "\r\n" + "\"account\":{\r\n" + "	\"accountno\" : \"123456789\",\r\n"
			+ "	\"balance\" : \"100000\",\r\n" + "	\"overdraft\" : \"80000\"\r\n" + "},\r\n" + "\r\n"
			+ "\"branches\":{\r\n" + "	\"type\" : \"Sub-branch\",\r\n" + "	\"location\" : \"Bengaluru\"\r\n"
			+ "	\r\n" + "},\r\n" + "\r\n" + "\"customer\":{\r\n" + "	\"name\" : \"James\",\r\n"
			+ "	\"dob\" : \"10-12-2018\",\r\n" + "	\"address\" : \"bengaluru\",\r\n"
			+ "	\"accountNo\" : \"123456789\",\r\n" + "	\"panNo\" : \"12AB23HH\"\r\n" + "}\r\n" + "}";

	private String customerMessage = "{\\r\\n\" + \"\\\"customerquery\\\":{\\r\\n\" + \"\\\"query\\\":\\\"messagereceived\\\",\\r\\n\"\r\n"
			+ "			+ \"\\\"resolution\\\" :\\\"true\\\",\\r\\n\" + \"}\\r\\n\" + \"}";

	@Autowired
	private JmsTemplate jmsTemplate;

	@Value("${springjms.accountQueue}")
	private String accountQueue;

	@Value("${springjms.customerQueue}")
	private String customerQueue;

	public void send(String message) {
//		jmsTemplate.convertAndSend(accountQueue, message);
		jmsTemplate.convertAndSend(customerQueue, message);
	}

	@Test
	public void testSendAndReceive() {
//		send(accountMessage);
		send(customerMessage);
	}

}
