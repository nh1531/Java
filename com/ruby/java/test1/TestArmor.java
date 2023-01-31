package com.ruby.java.test1;

/* class Armor2 {
		private String name;
		private int height;
		public int takeOff(int value) {
		System.out.println("엔진 시동: value =" + value);
		return value - 50;
	}
*/

public class TestArmor {
	// p. 208
	static void test(int ... v) {
		System.out.println(v.length + ":");
		for(int x : v)
			System.out.println(x + "");
		System.out.println();
	}
	
	public static void main(String[] args) {
		int n;
		int [][]arr =new int[3][4];
		Armor a = new Armor(); // 같은 package 안에 있는 클래스 호출
		n = a.takeOff(100); // 함수 호출
		a.speedUp(11);
		System.out.println("n = " + n);
		
//		test(1);
//		test(1, 2);
//		test(1, 2, 3);
		
		a.setHeight(10);
	}
}

// not visible 에러
// public / private에 관련된 문제

// method ... is undefined 
// method 가 구현되지 않음. 함수 구현x