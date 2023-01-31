package com.ruby.java.ch09;

public class Test01 {

	public static void main(String[] args) {
		Object obj1 = new Object();
		Object obj2 = new Object();
		Object obj3 = new Object();
		
		Class c = obj1.getClass();
		
		System.out.println(obj1.hashCode());
		System.out.println(obj2.hashCode());
		System.out.println(obj3.hashCode());
		
		System.out.println(c.getName());
		// System.out.println(obj1.getClass().getName()); // 10+16
		
		System.out.println(obj1.toString());
		System.out.println(obj2.toString());
		System.out.println(obj3.toString());
		
		
		MyObject obj4 = new MyObject(123);
		// System.out.println(obj4);
		
		MyObject obj5 = new MyObject(123);
		if(obj4.equals(obj5)) {
			System.out.println("동일 객체이다.");
		} else {
			System.out.println("다른 객체이다");
		}
		
		if(obj4 == obj5) {
			System.out.println("동일 객체이다.");
		} else {
			System.out.println("다른 객체이다");
		}
		
		
		
		
		
		
		
		
		
		
		// == , equals() 차이 
		// 두 문자열의 값이 같냐 -> equals()
		// == 잘 안씀
		// 기본적으로 객체 비교는 equals로 비교한다
		// 8가지 기본 데이터 타입은 equals를 못 씀.
		// int a = 10; a.equals (x)
		// '' -> char 1글자짜리 char
		// char a = 'a'; (o) "a" (x) 'ab'(x)
		// " " -> String 
		// String s = "b" (o) "bcd" (o. 여러글자 ) 'b'(x)
		
				
	}

}
