package com.abcbank.exceptions;

import java.time.LocalDateTime;


public class ApiException {
	
	private LocalDateTime localDateTime;
	private String message;
	private String details;
	private String exception;
	
	public ApiException(LocalDateTime localDateTime, String message, String details, String exception) {
		this.localDateTime = localDateTime;
		this.message = message;
		this.details = details;
		this.exception = exception;
	}

	public LocalDateTime getLocalDateTime() {
		return localDateTime;
	}

	public void setLocalDateTime(LocalDateTime localDateTime) {
		this.localDateTime = localDateTime;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getException() {
		return exception;
	}

	public void setException(String exception) {
		this.exception = exception;
	}
}
