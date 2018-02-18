package com.abcbank.counterstrategy;

import java.util.List;
import java.util.stream.Collectors;

import com.abcbank.models.BankCounter;
import com.abcbank.models.BankService;
import com.abcbank.models.CustomerType;
import com.abcbank.models.Token;
import com.abcbank.services.BankAdminService;


public class GreedyBankCounterStrategy implements BankCounterStrategy {

	
	@Override
	public BankCounter getBankCounterForToken ( Token token, BankAdminService bankAdminService)
	{
		BankService bankService = token.getBankService();
		BankCounter bankCounter = getBankCounterForService(bankService, token.getCustomer().getCustomerType(), bankAdminService);
		return bankCounter;
	}

	private BankCounter getBankCounterForService ( BankService bankService, CustomerType customerType, BankAdminService bankAdminService )
	{
		List<BankCounter> bankCounters = bankAdminService.getBankCountersByServiceType(bankService);
		if(customerType == CustomerType.PREMIUM) {
			return getBankCounterForPremiumType(bankCounters);
		}
		else {
			return getBankCounterForRegularType(bankCounters);
		}
	}

	private BankCounter getBankCounterForRegularType ( List<BankCounter> bankCounters )
	{
		int minimum = Integer.MAX_VALUE;
		BankCounter result = null;
		for(BankCounter bankCounter : bankCounters) {
			if(bankCounter.getCustomerQueue().size() < minimum) {
				result = bankCounter;
				minimum = bankCounter.getCustomerQueue().size();
			}
		}
		
		return result;
	}

	private BankCounter getBankCounterForPremiumType ( List<BankCounter> bankCounters )
	{
		int minimum = Integer.MAX_VALUE;
		BankCounter result = null;
		for(BankCounter bankCounter : bankCounters) {
			List<Token> tokens = bankCounter.getCustomerQueue()
											.stream()
											.filter(token -> token.getCustomer().getCustomerType() == CustomerType.PREMIUM)
											.collect(Collectors.toList());
			
			if(tokens.size() < minimum) {
				minimum = tokens.size();
				result = bankCounter;
			}
			
		}
		
		return result;
	}
	
	
	
}

