package com.abcbank.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "bankServices")
public class BankService {

	@Id
	private String bankServiceId;
	private String bankServiceName;
	
	public BankService() {
		// empty constructor
	}
	
	public BankService(String bankServiceId, String bankServiceName) {
		this.bankServiceId = bankServiceId;
		this.bankServiceName = bankServiceName;
	}

	public String getBankServiceId() {
		return bankServiceId;
	}

	public void setBankServiceId(String bankServiceId) {
		this.bankServiceId = bankServiceId;
	}

	public String getBankServiceName() {
		return bankServiceName;
	}

	public void setBankServiceName(String bankServiceName) {
		this.bankServiceName = bankServiceName;
	}

}
