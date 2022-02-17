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

	private String message = "{\n" + "   \"accountType\":{\n" + "      \"transactionLimit\":\"20000\",\n"
			+ "      \"depositAmount\":\"50000\",\n" + "      \"withdrawlLimit\":\"69000\",\n"
			+ "      \"interestRate\":\"66\"\n" + "   },\n" + "   \"account\":{\n" + "      \"accountNo\":\"987456\",\n"
			+ "      \"balance\":\"200000\",\n" + "      \"overDraft\":\"60000\"\n" + "   },\n" + "   \"branches\":{\n"
			+ "      \"type\":\"main\",\n" + "      \"location\":\".khjjhg\"\n" + "   },\n" + "   \"customer\":{\n"
			+ "      \"name\":\"gyutry\",\n" + "      \"dob\":\"10-12-1996\",\n" + "      \"address\":\"Hennur\",\n"
			+ "      \"accountNo\":\"987456\",\n" + "      \"panNo\":\"12AN125ZZ\"\n" + "   }\n" + "}";

	private String customerMessage = "{\\r\\n\" + \"\\\"customerquery\\\":{\\r\\n\" + \"\\\"query\\\":\\\"messagereceived\\\",\\r\\n\"\r\n"
			+ "			+ \"\\\"resolution\\\" :\\\"true\\\",\\r\\n\" + \"}\\r\\n\" + \"}";

	@Autowired
	private JmsTemplate jmsTemplate;

	@Value("${springjms.accountQueue}")
	private String accountQueue;

	@Value("${springjms.customerQueue}")
	private String customerQueue;

//	public void send(String message) {
////		jmsTemplate.convertAndSend(accountQueue, message);
////		jmsTemplate.convertAndSend(customerQueue, message);
//	}

	@Test
	public void testSendAndReceive() {
//		send(accountMessage);
		jmsTemplate.convertAndSend(accountQueue, message);
	}

}
