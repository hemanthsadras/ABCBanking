package com.abcbank.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abcbank.models.Token;
import com.abcbank.services.TokenService;

@RestController
@RequestMapping("/token")
public class TokenController {
	
	@Autowired
	private TokenService tokenService;
	
	public TokenController(TokenService tokenService) {
		this.tokenService = tokenService;
	}
	
	@PostMapping
	public String generateTokenAndAssignToCounter(@RequestBody Token token) {
		return this.tokenService.assignTokenToCounter(token);
	}
	

}
