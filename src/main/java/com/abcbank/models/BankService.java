package com.abcbank.models;

import java.util.Objects;

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
	
	@Override
	public boolean equals(Object object) {
		Objects.requireNonNull(object);
		if(object instanceof BankService) {
			BankService bankService = (BankService) object;
			return bankService.getBankServiceName().equals(this.getBankServiceName());
		}
		else {
			return false;
		}
	}
	
	@Override
	public int hashCode() {
		return bankServiceName.length() + 13;
	}

}
