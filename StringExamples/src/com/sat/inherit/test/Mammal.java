package com.sat.inherit.test;

import com.sat.interfaces.Animal;

public class Mammal implements Animal{

	@Override
	public boolean doIBreath() {
		System.out.println("Yes I do Breath with Lungs");
		return false;
	}

	@Override
	public void whatIEat() {
		System.out.println("I can Eat Veg or Non-Veg");
		
	}

	@Override
	public void howIMove() {
		System.out.println("by Foot or Crawl");
		
	}

	@Override
	public void whereDoILive() {
		System.out.println("in Wild or Domestic");
		
	}

}
