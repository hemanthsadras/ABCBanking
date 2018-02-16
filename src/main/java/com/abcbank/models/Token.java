package com.abcbank.models;

public class Token  implements Comparable<Token>{

	private String customerId;
	private CustomerType customerType;
	private BankService bankService;
	private TokenStatus tokenStatus;

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

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

	public CustomerType getCustomerType() {
		return customerType;
	}

	public void setCustomerType(CustomerType customerType) {
		this.customerType = customerType;
	}

	@Override
	public int compareTo(Token otherToken) {
		boolean isTokenOnePremium = isTokenPremium(this);
		boolean istokenTwoPremium = isTokenPremium(otherToken);
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
		return token.getCustomerType() == CustomerType.PREMIUM;
	}

}
