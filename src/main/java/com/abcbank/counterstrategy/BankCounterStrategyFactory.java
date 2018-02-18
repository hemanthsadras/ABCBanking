package com.abcbank.counterstrategy;

public class BankCounterStrategyFactory {
	
	public static BankCounterStrategy getInstance(CounterStrategy counterStrategy) {
		
		switch(counterStrategy) {
			case GREEDY : return new GreedyBankCounterStrategy();
			default : throw new RuntimeException("Invalid bank counter strategy");
		}

	}
}