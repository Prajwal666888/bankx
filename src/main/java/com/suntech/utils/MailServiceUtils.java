package com.suntech.utils;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.stereotype.Component;

@Component
public class MailServiceUtils {

	private static final String SUCCESS_MESSAGE = "Account has been successfully opened.";
	private static final String FAILURE_MESSAGE = "Failed to open account.";

	/**
	 * @param receiverMail
	 * @param content
	 * @param success
	 * @throws AddressException
	 * @throws MessagingException
	 * @throws IOException
	 */
	public void sendmail(String receiverMail, String content, Boolean success)
			throws AddressException, MessagingException, IOException {
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		javax.mail.Session session = javax.mail.Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("sfernandis4@gmail.com", "Stephan@123");
			}
		});
		Message msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress("sfernandis4@gmail.com", false));

		msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(receiverMail));
		MimeBodyPart messageBodyPart = new MimeBodyPart();
		if (success) {
			msg.setSubject(SUCCESS_MESSAGE);
			msg.setContent("BankX", "text/html");
			msg.setSentDate(new Date());
			messageBodyPart.setContent(content, "text/html");
		} else {
			msg.setSubject(FAILURE_MESSAGE);
			msg.setContent("BankX", "text/html");
			msg.setSentDate(new Date());
			messageBodyPart.setContent(content, "text/html");
		}

		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(messageBodyPart);

		msg.setContent(multipart);
		Transport.send(msg);
	}

}
