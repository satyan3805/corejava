package com.sat;

import java.io.*;

public class Main {

	public static void main(String[] args) {

		Customer c1 = new Customer("satya", 1);
		Customer c2 = new Customer("ravi", 2);

		CustomerCollection.AddNewCustomer(c1);
		CustomerCollection.AddNewCustomer(c2);

		System.out.println("****Reading File****");
		CustomerCollection.readFile();
	}
}