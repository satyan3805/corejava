package com.sat;

import java.io.*;

public class Customer implements Serializable {
	// Private class variables
	private String name;
	private long acc_No;

	// Class Constructor
	Customer(String n, long id) {
		acc_No = id;
		name = n;
	}

	// Getter methods of class variables
	public String getCustomerName() {
		return name;
	}

	public long getAccountNumber() {
		return acc_No;
	}
}
