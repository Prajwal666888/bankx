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

	
	private String cardMessage = " {\r\n"
			+ " 	\"cardNo\": \"212345\",\r\n"
			+ " 	\"validFrom\": \"01-01-2021\",\r\n"
			+ " 	\"validTo\": \"01-01-2025\"\r\n"
			+ "\r\n"
			+ " }";
			

	private String customerMessage = 
			"{\r\n"
			+ " 	\"query\": \"messagereceived\",\r\n"
			+ " 	\"resolution\": true\r\n"
			+ " }";
	
	private String loanMessage ="{\r\n"
			+ " 	\"amount\": \"20000\",\r\n"
			+ " 	\"loanType\": \"Home loan\",\r\n"
			+ " 	\"rateOfInterest\": \"5\",\r\n"
			+ " 	\"term\": \"short\"\r\n"
			+ " }";
	
	
	@Autowired
	private JmsTemplate jmsTemplate;

	@Value("${springjms.accountQueue}")
	private String accountQueue;

	@Value("${springjms.customerQueue}")
	private String customerQueue;
	
	@Value("${springjms.loanQueue}")
	private String loanQueue;

//	public void send(String message) {
////		jmsTemplate.convertAndSend(accountQueue, message);
////		jmsTemplate.convertAndSend(customerQueue, message);
//	}
	
	@Value("${springjms.cardQueue}")
	private String cardQueue;


	
	public void send(String message) {
//		jmsTemplate.convertAndSend(accountQueue, message);
//		jmsTemplate.convertAndSend(customerQueue, message);
	//	jmsTemplate.convertAndSend(loanQueue,message);
		jmsTemplate.convertAndSend(cardQueue,message);
	}

	@Test
	public void testSendAndReceive() {
//		send(accountMessage);
		jmsTemplate.convertAndSend(accountQueue, message);
//		send(accountMessage);
//		send(customerMessage);
//		send(loanMessage);
		send(cardMessage);
		
	}

}
