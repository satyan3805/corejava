package com.sat.inherit;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.sat.exception.DateOutofRangeException;

public class InheritExample {
	
	static String str1 = "PARENT_STR";
	
	public static void printOutput() {
		
		System.out.println("TEST0");
		int numOne = 23;
		
		try {
			int denomVal = 1;
			boolean riseDateException = true;
			System.out.println(numOne/denomVal);
			System.out.println("TEST2");
			if(riseDateException) {
				throw new DateOutofRangeException();
			}
			throw new IOException();
		}
		catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
			System.out.println("there is some arithmatic calculation error.");
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println("there is some File Access error.");
		}catch(DateOutofRangeException e) {
			e.printStackTrace();
			System.out.println("DOB is out of range for Employee");
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("there is some un handled error please contact admin.");
		}
		finally {
			System.out.println("Finally block executed");
		}
		
		System.out.println("TEST3");
		System.out.println("TEST4");
		System.out.println("TEST5");
	}
	
	public static void main(String args[]) {
		System.out.println(str1);
		printOutput();
		
	}
}
//
//class TestInterfaceOne extends InheritExample{
//	public void methodOne(){
//		
//	}
//}
//
//class TestInterface extends TestInterfaceOne{
//	final String strTest="SAMPLE";
//	public void methodOne() {
//		
//	}
//}
