package com.suntech.schedular;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.suntech.dao.AccountDao;
import com.suntech.dao.CustomerDao;
import com.suntech.domain.Account;
import com.suntech.domain.Customer;
import com.suntech.domain.Account;
import com.suntech.utils.MailServiceUtils;

/**
 * @author Stephan Fernandes
 *
 */

@Component
public class BankxSchedular {
	
	@Autowired
	private AccountDao accountDao;
	
	@Autowired
	private MailServiceUtils mailServiceUtils;
	//fields to send mail
	private String email;
	private String content;
	private String subject;
	
	
	//CronOperation:-last day of the month at noon
	@Scheduled(cron = "0 0 12 L * ?")
	public void monthSchedular() {
		
		System.out.println("schedular is working evry 10 seconds");
		List<Account> accounts = accountDao.findAll();
		for(Account account : accounts ) {
			//Print the customer details and Balance 
			System.out.println("Customer Details"+account.getCustomer().toString());
			System.out.println("Current Account Balance"+account.getBalance());
			//Triggering mail for respected mail id
			email=account.getCustomer().getEmail();
			content="Current account balance is "+account.getBalance();
			subject="Monthly balance";
			try {
				mailServiceUtils.sendmail(email, content, Boolean.TRUE, subject);
				System.out.println("Email sent successfully");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				} 
			}
			
		}
		
	}


	Logger logger = LoggerFactory.getLogger(BankxSchedular.class);

	@Autowired
	private CustomerDao customerDao;

	@Autowired
	private AccountDao accountDao;

	@Autowired
	private MailServiceUtils mailServiceUtils;
	// fields to send mail
	private String email;
	private String content;
	private String subject;

	// CronOperation:-last day of the month at noon
	@Scheduled(cron = "0 0 12 L * ?")
	public void monthSchedular() {

		System.out.println("schedular is working evry 10 seconds");
		List<Account> accounts = accountDao.findAll();
		for (Account account : accounts) {
			// Print the customer details and Balance
			System.out.println("Customer Details" + account.getCustomer().toString());
			System.out.println("Current Account Balance" + account.getBalance());
			// Triggering mail for respected mail id
			email = account.getCustomer().getEmail();
			content = "Current account balance is " + account.getBalance();
			subject = "Monthly balance";
			try {
				mailServiceUtils.sendmail(email, content, Boolean.TRUE, subject);
				System.out.println("Email sent successfully");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	// */5 * * * * * (for every 5 second)

	@Scheduled(cron = "0 0 * * *")
	public void birthDaySchedular() throws Exception {

		List<Customer> allCustomer = customerDao.findAll();
		for (Customer c : allCustomer) {
			LocalDate currentDate = LocalDate.now();
			LocalDate dob = c.getDob().toLocalDate();
			if (currentDate.getMonth().equals(dob.getMonth()) && currentDate.getDayOfMonth() == dob.getDayOfMonth()) {

				email = c.getEmail();
				content = "WISHING YOU HAPPY BIRTHDAY....";
				subject = "BIRTHDAY WISHES";

				mailServiceUtils.sendmail(email, content, Boolean.TRUE, subject);
				logger.info("Successfully sent.....");

			}
		}

	}

}
