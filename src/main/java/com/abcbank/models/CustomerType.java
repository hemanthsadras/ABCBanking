package com.abcbank.models;

public enum CustomerType {
	
	REGULAR("Regular"),
	PREMIUM("Premium");
	
	private String value;
	
	CustomerType(String value){
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
	
	

}
