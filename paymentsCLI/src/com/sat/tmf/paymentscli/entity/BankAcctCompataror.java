package com.sat.tmf.paymentscli.entity;

import java.util.Comparator;

public class BankAcctCompataror implements Comparator {

	@Override
	public int compare(Object obj1, Object obj2) {
		BankAccount ba1 = (BankAccount) obj1;
		BankAccount ba2 = (BankAccount) obj2;
		if (ba1.getBankAcctNumber().equals(ba2.getBankAcctNumber())) {
			return 0;
		} else if (Long.valueOf(ba1.getBankAcctNumber()) > Long.valueOf(ba2.getBankAcctNumber())) {
			return 1;
		} else {
			return -1;
		}
		
	}

}
