package com.suntech.exception;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.suntech.domain.ExceptionAudit;
import com.suntech.service.ExceptionAuditService;

/**
 * @author sujayh
 *
 */

@ControllerAdvice
@RestController
public class BankxExceptionHandler extends ResponseEntityExceptionHandler {
	
	@Autowired
	private ExceptionAuditService exceptionAuditService;

	// handling the rest controller exception
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handellAllExceptions(Exception exception, WebRequest request) {
		ExceptionAudit exceptionResponse = new ExceptionAudit(exception.getMessage(), request.toString(), new Date(),
				Arrays.toString(exception.getStackTrace()));
		exceptionAuditService.createAndSaveBank(exceptionResponse);
		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
