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

	private String message = "{\r\n" + " 	\"accountType\": {\r\n" + " 		\"transactionLimit\": \"20000\",\r\n"
			+ " 		\"depositAmount\": \"50000\",\r\n" + " 		\"withdrawlLimit\": \"69000\",\r\n"
			+ " 		\"interestRate\": \"66\"\r\n" + " 	},\r\n" + " 	\"account\": {\r\n"
			+ " 		\"accountNo\": \"987456\",\r\n" + " 		\"balance\": \"200000\",\r\n"
			+ " 		\"overDraft\": \"60000\"\r\n" + " 	},\r\n" + " 	\"branches\": {\r\n"
			+ " 		\"type\": \"main\",\r\n" + " 		\"location\": \".khjjhg\"\r\n" + " 	},\r\n"
			+ " 	\"customer\": {\r\n" + " 		\"name\": \"gyutry\",\r\n" + " 		\"dob\": \"10-12-1996\",\r\n"
			+ " 		\"address\": \"Hennur\",\r\n" + " 		\"accountNo\": \"987456\",\r\n"
			+ " 		\"panNo\": \"12AN125ZZ\",\r\n" + " 		\"email\": \"asifpasha559@gmail.com\"\r\n" + " 	}\r\n"
			+ " }";

	private String cardMessage = " {\r\n" + " 	\"cardNo\": \"212345\",\r\n" + " 	\"validFrom\": \"01-01-2021\",\r\n"
			+ " 	\"validTo\": \"01-01-2025\"\r\n" + "\r\n" + " }";

	private String customerMessage = "{\r\n" + " 	\"query\": \"messagereceived\",\r\n"
			+ " 	\"resolution\": true\r\n" + " }";

	private String loanMessage = "{\r\n" + " 	\"amount\": \"20000\",\r\n" + " 	\"loanType\": \"Home loan\",\r\n"
			+ " 	\"rateOfInterest\": \"5\",\r\n" + " 	\"term\": \"short\"\r\n" + " }";

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
		jmsTemplate.convertAndSend(accountQueue, message);
//		jmsTemplate.convertAndSend(customerQueue, message);
		// jmsTemplate.convertAndSend(loanQueue,message);
//		jmsTemplate.convertAndSend(cardQueue,message);
	}

	@Test
	public void testSendAndReceive() {
		send(message);
//		jmsTemplate.convertAndSend(accountQueue, message);
//		send(accountMessage);
//		send(customerMessage);
//		send(loanMessage);
//		send(cardMessage);

	}

}
