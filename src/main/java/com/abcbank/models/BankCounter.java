package com.abcbank.models;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="bankCounters")
public class BankCounter {

	@Id
	private String counterId;
	private String bankCounterName;
	private BankService bankService;
	private PriorityQueue<Token> customerQueue = new PriorityQueue<>();
	@Transient
	private List<Token> customerPrioriryList = new ArrayList<>();

	public String getCounterId() {
		return counterId;
	}

	public void setCounterId(String counterId) {
		this.counterId = counterId;
	}

	public BankService getBankService() {
		return bankService;
	}

	public void setBankService(BankService bankService) {
		this.bankService = bankService;
	}

	public PriorityQueue<Token> getCustomerQueue() {
		return customerQueue;
	}

	public void setCustomerQueue(PriorityQueue<Token> customerQueue) {
		this.customerQueue = customerQueue;
	}

	public String getBankCounterName() {
		return bankCounterName;
	}

	public void setBankCounterName(String bankCounterName) {
		this.bankCounterName = bankCounterName;
	}
	
	public List<Token> getCustomerPriorityList() {		
		PriorityQueue<Token> tempQueue = new PriorityQueue<>(customerQueue);
		while(!tempQueue.isEmpty()) {
			customerPrioriryList.add(tempQueue.poll());
		}		
		return customerPrioriryList;
	}

}
