package com.suntech.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author sujayh
 *
 */
@Entity
@Table(name = "exceptionaudit")
public class ExceptionAudit extends IdDomain {

	@Column(name = "errormessage")
	private String errorMessage;

	@Column(name = "errordetails")
	private String errorDetail;

	@Column(name = "time")
	private Date time;

	@Column(name = "stacktrace")
	private String stacktrace;

	public ExceptionAudit() {
		super();
	}

	public ExceptionAudit(String errorMessage, String errorDetail, Date time, String stacktrace) {
		super();
		this.errorMessage = errorMessage;
		this.errorDetail = errorDetail;
		this.time = time;
		this.stacktrace = stacktrace;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorDetail() {
		return errorDetail;
	}

	public void setErrorDetail(String errorDetail) {
		this.errorDetail = errorDetail;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getStacktrace() {
		return stacktrace;
	}

	public void setStacktrace(String stacktrace) {
		this.stacktrace = stacktrace;
	}

}
