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
	private BankCounterService bankCounterService;
	
	public TokenService(BankCounterService bankCounterService) {
		this.bankCounterService = bankCounterService;
	}
	
	public String assignTokenToCounter(Token token) {
		BankCounterStrategy bankCounterStrategy = BankCounterStrategyFactory.getInstance(CounterStrategy.GREEDY);
		BankCounter bankCounter = bankCounterStrategy.getBankCounterForToken(token, bankCounterService);
		bankCounter.getCustomerQueue().add(token);
		this.bankCounterService.updateBankCounter(bankCounter);
		return bankCounter.getBankCounterName();
		
	}

}
