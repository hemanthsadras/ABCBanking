package com.abcbank.counterstrategy;

import com.abcbank.models.BankCounter;
import com.abcbank.models.Token;
import com.abcbank.services.BankAdminService;

public interface BankCounterStrategy
{
	BankCounter getBankCounterForToken(Token token, BankAdminService bankAdminService);
}
