package com.abcbank.models;

import java.util.Comparator;

public class TokenComparator implements Comparator<Token> {

	@Override
	public int compare(Token tokenOne, Token tokenTwo) {
		
		boolean isTokenOnePremium = isTokenPremium(tokenOne);
		boolean istokenTwoPremium = isTokenPremium(tokenTwo);
		if(isTokenOnePremium && !istokenTwoPremium) {
			return 1;
		}
		else if(!isTokenOnePremium && istokenTwoPremium) {
			return -1;
		}
		else {
			return 0;
		}
	}
	
	public boolean isTokenPremium(Token token) {
		return token.getCustomer().getCustomerType() == CustomerType.PREMIUM;
	}

}
