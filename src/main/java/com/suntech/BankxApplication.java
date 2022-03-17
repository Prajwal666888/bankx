package com.suntech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableScheduling
@EnableJms
@EnableWebSecurity
public class BankxApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankxApplication.class, args);
	}

}
