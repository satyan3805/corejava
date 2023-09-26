package com.sat.inherit;

public class InheritExample {
	
	String str1 = "PARENT_STR";
	
	protected void printOutput() {
		System.out.println(str1);
	}
}

interface TestInterfaceOne extends InheritExample{
	
}

interface TestInterface extends TestInterfaceOne{
	final String strTest="SAMPLE";
	public void methodOne();
}
