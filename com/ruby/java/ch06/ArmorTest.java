package com.ruby.java.ch06;

public class ArmorTest {
	public static void main(String[] args) {
		Armor suit1 = new Armor();
		Armor suit2 = new Armor();
		Armor suit3 = new Armor();
		
		suit1.setName("mark6");
		suit1.setHeight(180);
		
		suit2.setName("mark16");
		suit2.setHeight(220);
		
		suit3.setName("mark38");
		suit3.setHeight(200);
		
		System.out.println(suit1.getName() + " : " + suit1.getHeight());
		// 18 라인 = 20-22 라인
		// String s1 = suit1.getName();
		// int h1 = suit1.getHeight();
		// System.out.println(s1 + ":" + h1);
		
		System.out.println(suit2.getName() + " : " + suit2.getHeight());
		System.out.println(suit3.getName() + " : " + suit3.getHeight());
	}
	
}
