package com.sat;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class CustomerCollection {
	private static File f = new File("BankAccountt.txt");

	public static boolean readFile() {
		boolean status = false;
		try {
			f.createNewFile();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (f.length() != 0) {
			try {
				FileInputStream fis = null;
				fis = new FileInputStream("BankAccountt.txt");
				ObjectInputStream ois = new ObjectInputStream(fis);

				Customer c = null;

				while (fis.available() != 0) {
					c = (Customer) ois.readObject();
					long accNo = c.getAccountNumber();
					System.out.println(c.getCustomerName() + " & " + c.getAccountNumber());
					
				}
				ois.close();
				fis.close();
				status = true;
			} catch (Exception e) {
				System.out.println("Error Occurred" + e);
				e.printStackTrace();
			}
		}
		return status;
	}

	public static boolean AddNewCustomer(Customer c) {
		boolean status = false;
		if (c != null) {
			try {
				FileOutputStream fos = new FileOutputStream("BankAccountt.txt", true);
				if (f.length() == 0) {
					ObjectOutputStream oos = new ObjectOutputStream(fos);
					oos.writeObject(c);
					oos.close();
				} else {
					MyObjectOutputStream oos = new MyObjectOutputStream(fos);
					oos.writeObject(c);
					oos.close();
				}
				fos.close();
			} catch (Exception e) {
				System.out.println("Error Occurred" + e);
			}
			status = true;
		}
		return status;
	}
}