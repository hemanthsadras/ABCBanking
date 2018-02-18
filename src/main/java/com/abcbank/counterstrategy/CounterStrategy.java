package com.abcbank.counterstrategy;

public enum CounterStrategy
{
	GREEDY("Greedy");
	
	private String value;
	
	CounterStrategy(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
}
