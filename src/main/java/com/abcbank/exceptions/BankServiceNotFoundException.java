package com.abcbank.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BankServiceNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = -895120976872524345L;

	public BankServiceNotFoundException(String message) {
		super(message);
	}
}
