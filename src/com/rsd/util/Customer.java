package com.rsd.util;

import java.time.LocalDateTime;

public class Customer {

	private final CustomerType type;
	private final String customerName;
	private final LocalDateTime joiningDate;

	public Customer(CustomerType type, String customerName) {
		this.type = type;
		this.customerName = customerName;
		joiningDate = LocalDateTime.now();
	}

	public Customer(CustomerType type, String customerName, LocalDateTime joiningDate) {
		this.type = type;
		this.customerName = customerName;
		this.joiningDate = joiningDate;
	}

	public CustomerType getType() {
		return type;
	}

	public String getCustomerName() {
		return customerName;
	}

	public LocalDateTime getJoiningDate() {
		return joiningDate;
	}

}
