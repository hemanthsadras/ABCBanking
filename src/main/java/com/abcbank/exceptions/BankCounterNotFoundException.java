package com.abcbank.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BankCounterNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = -3546623567440065680L;

	public BankCounterNotFoundException(String message) {
		super(message);
	}

}
