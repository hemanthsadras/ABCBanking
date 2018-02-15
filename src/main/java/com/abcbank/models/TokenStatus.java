package com.abcbank.models;

public enum TokenStatus {
	
	COMPLETED("Completed"),
	CANCELLED("Cancelled"),
	TO_BE_STARTED("ToBeStarted"),
	IN_PROGRESS("InProgress");
	
	private String value;
	
	TokenStatus(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
	

}
