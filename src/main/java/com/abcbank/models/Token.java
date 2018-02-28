package com.abcbank.models;

import java.util.Objects;

public class Token  implements Comparable<Token>{

	private Customer customer;
	private BankService bankService;
	private TokenStatus tokenStatus;

	public BankService getBankService() {
		return bankService;
	}

	public void setBankService(BankService bankService) {
		this.bankService = bankService;
	}

	public TokenStatus getTokenStatus() {
		return tokenStatus;
	}

	public void setTokenStatus(TokenStatus tokenStatus) {
		this.tokenStatus = tokenStatus;
	}


	public Customer getCustomer ()
	{
		return customer;
	}

	public void setCustomer ( Customer customer )
	{
		this.customer = customer;
	}

	@Override
	public int compareTo(Token otherToken) {
		boolean isTokenOnePremium = isTokenPremium(this);
		boolean istokenTwoPremium = isTokenPremium(otherToken);
		if(isTokenOnePremium && !istokenTwoPremium) {
			return -1;
		}
		else if(!isTokenOnePremium && istokenTwoPremium) {
			return 1;
		}
		else {
			return 0;
		}
	}
	
	public boolean isTokenPremium(Token token) {
		return token.getCustomer().getCustomerType().equals(CustomerType.PREMIUM);
	}
	
	@Override
	public boolean equals(Object token) {
		Objects.requireNonNull(token);
		if(token instanceof Token) {
			Token otherToken = (Token) token;
			if(otherToken.getCustomer().equals(this.getCustomer()) && otherToken.getBankService().equals(this.getBankService()))
				return true;
		}
		
		return false;
	}

}
