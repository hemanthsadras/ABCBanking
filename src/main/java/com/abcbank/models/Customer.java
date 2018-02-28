package com.abcbank.models;

import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "customers")
public class Customer {

	@Id
	private String id;
	private String name;
	private String emailId;
	private CustomerType customerType;

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
	
	@Override
	public boolean equals(Object customer) {
		Objects.requireNonNull(customer);
		if(customer instanceof Customer) {
			Customer that = (Customer) customer;
			boolean isSameId = that.getId().equals(this.getId());
			boolean isSameName = that.getName().equals(this.getName());
			boolean isSameType = that.getCustomerType().equals(this.getCustomerType());
			boolean isSameEmailId = that.getEmailId().equals(this.getEmailId());
			return isSameId && isSameName && isSameType && isSameEmailId;
		}
		
		return false;
	}

}
