package com.sat;

import com.sat.inherit.test.ThirdClass;
import com.sat.inherit.SecondClass;

public class StringOps {

	private int str1;

	public static void main(String[] args) {
		
		ThirdClass t1 = new ThirdClass();
		SecondClass s1 = new SecondClass();
		
		
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
