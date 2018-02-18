package com.abcbank.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abcbank.counterstrategy.BankCounterStrategy;
import com.abcbank.counterstrategy.BankCounterStrategyFactory;
import com.abcbank.counterstrategy.CounterStrategy;
import com.abcbank.models.BankCounter;
import com.abcbank.models.Token;

@Service
public class TokenService {
	
	@Autowired
	private BankAdminService bankAdminService;
	
	public TokenService(BankAdminService bankAdminService) {
		this.bankAdminService = bankAdminService;
	}
	
	public String assignTokenToCounter(Token token) {
		BankCounterStrategy bankCounterStrategy = BankCounterStrategyFactory.getInstance(CounterStrategy.GREEDY);
		BankCounter bankCounter = bankCounterStrategy.getBankCounterForToken(token, bankAdminService);
		bankCounter.getCustomerQueue().add(token);
		this.bankAdminService.updateBankCounter(bankCounter);
		return bankCounter.getBankCounterName();
		
	}

}
