package com.sat;

import com.sat.inherit.test.ThirdClass;
import com.sat.inherit.SecondClass;

public class StringOps {

	private int str1;

	public static void main(String[] args) {
		
//		ThirdClass t1 = new ThirdClass();
//		t1.printOutput();
		
		SecondClass s1 = new SecondClass();
		
		int i=10;
		Integer k = new Integer(20);
		Integer j = new Integer(20);
		
		
		if(j.equals(k)) {
			System.out.println("both are same");
		}else {
			System.out.println("both are not same");
		}
		
		
//		String s1 = "Examples";
//		String s2 = new String("Examples");
//		String s3 = "Examples";
//		String s4 = new String("Examples");
//		
//		String s5 = s1;
//
//		if(s1.equals(s5)) {
//			System.out.println("Both are same.");
//		}else {
//			System.out.println("Both are not same.");
//		}
//		
//		TestImmutable tI = new TestImmutable();
//		tI.setI(10); 
//		System.out.println(tI.getI());
		

	}

}

class TestImmutable{
	private int i;

	public int getI() {
		return i;
	}

	public void setI(int i) {
		
		this.i = i*i;
	}
	
}
