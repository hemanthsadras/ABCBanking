package com.abcbank.controllers;


import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.abcbank.exceptions.ApiException;

@ControllerAdvice
@RestController
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class) 
	public final ResponseEntity<ApiException> handleRuntimeExceptions(Exception exception, WebRequest request) {
		ApiException apiException = new ApiException(LocalDateTime.now(), exception.getMessage(), request.getDescription(false), exception.getClass().toString());
		return new ResponseEntity<ApiException>(apiException, HttpStatus.NOT_FOUND);
	}
}
