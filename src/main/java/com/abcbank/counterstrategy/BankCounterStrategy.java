package com.abcbank.counterstrategy;

import com.abcbank.models.BankCounter;
import com.abcbank.models.Token;
import com.abcbank.services.BankCounterService;

public interface BankCounterStrategy
{
	BankCounter getBankCounterForToken(Token token, BankCounterService bankCounterService);
}
