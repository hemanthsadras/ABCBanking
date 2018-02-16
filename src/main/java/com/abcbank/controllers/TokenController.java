package com.abcbank.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abcbank.models.BankCounter;
import com.abcbank.models.BankService;
import com.abcbank.models.CustomerType;
import com.abcbank.models.Token;
import com.abcbank.models.TokenStatus;
import com.abcbank.services.BankAdminService;

@RestController
@RequestMapping("/token")
public class TokenController {
	
	@Autowired
	private BankAdminService bankAdminService;
	
	public TokenController(BankAdminService bankAdminService) {
		this.bankAdminService = bankAdminService;
	}
	
	@PostMapping
	public String generateTokenAndAssignToCounter(@RequestBody Token token) {
		BankService bankService = token.getBankService();
		List<BankCounter> bankCounter = bankAdminService.getBankCountersByServiceType(bankService);
		bankCounter.get(0).getCustomerQueue().add(token);
		bankAdminService.updateBankCounter(bankCounter.get(0));
		return bankCounter.get(0).getCounterId();	
	}
	
	@GetMapping
	public Token getDummyToken() {
		Token token = new Token();
		token.setBankService(new BankService("123", "Loan"));
		token.setCustomerId("1234");
		token.setCustomerType(CustomerType.PREMIUM);
		token.setTokenStatus(TokenStatus.TO_BE_STARTED);
	    return token;
	}
	

}
