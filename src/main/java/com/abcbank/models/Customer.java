package com.abcbank.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "documents")
public class Customer {

	@Id
	private String id;
	private String name;
	private String emailId;
	private CustomerType customerType;
	private List<String> bankServices;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public CustomerType getCustomerType() {
		return customerType;
	}

	public void setCustomerType(CustomerType customerType) {
		this.customerType = customerType;
	}

	public List<String> getBankServices() {
		return bankServices;
	}

	public void setBankServices(List<String> bankServices) {
		this.bankServices = bankServices;
	}

}
