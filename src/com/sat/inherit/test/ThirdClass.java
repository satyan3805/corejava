package com.sat.inherit.test;

import com.sat.inherit.SecondClass;

public class ThirdClass extends SecondClass{
	String str2= "Child_STR";
	
	public void justAPrint2() {
		System.out.println("from Just a Print");
		justAPrint1();
		printOutput();
	}
	
}
