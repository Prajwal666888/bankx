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

	@Autowired
	private JmsTemplate jmsTemplate;

	@Value("${springjms.accountQueue}")
	private String queue;

	public void send(String message) {

		jmsTemplate.convertAndSend(queue, message);

	}

	private String message = "{\r\n" + "\"accountType\":{\r\n" + "	\"transactionlimit\": \"50000\",\r\n"
			+ "	\"depositamt\":\"20000\",\r\n" + "	\"withdrawllimit\":\"49000\",\r\n" + "	\"interestrate\":\"8\"\r\n"
			+ "},\r\n" + "\r\n" + "\"account\":{\r\n" + "	\"accountno\" : \"123456789\",\r\n"
			+ "	\"balance\" : \"100000\",\r\n" + "	\"overdraft\" : \"80000\"\r\n" + "},\r\n" + "\r\n"
			+ "\"branches\":{\r\n" + "	\"type\" : \"Sub-branch\",\r\n" + "	\"location\" : \"Bengaluru\"\r\n"
			+ "	\r\n" + "},\r\n" + "\r\n" + "\"customer\":{\r\n" + "	\"name\" : \"James\",\r\n"
			+ "	\"dob\" : \"10-12-2018\",\r\n" + "	\"address\" : \"bengaluru\",\r\n"
			+ "	\"accountNo\" : \"123456789\",\r\n" + "	\"panNo\" : \"12AB23HH\"\r\n" + "}\r\n" + "}";

	@Test
	public void testSendAndReceive() {
		send(message);
	}

}
