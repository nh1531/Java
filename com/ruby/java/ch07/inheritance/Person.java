package com.ruby.java.ch07.inheritance;

public class Person {
	private final String ssn_ID = "123" ; // final을 쓰면 값을 초기화 해야 함
	private String name;
	private int age;
	
//	public void setSsn_ID(String ssn_ID) {
//		// The final field Person.ssn_ID cannot be assigned
//		this.ssn_ID = ssn_ID;
//	}

	public Person() {
		System.out.println("Person 생성자 실행");
	}
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
// 11-14 행과 동일
// 그렇지만 위의 방법이 좋음. 나중에 봤을 때 n, a 기억 안남. readable 읽기 쉽고 판독하기 쉽고 다른 사람이 쉽게 이해할 수 있는 코드가 좋음
//	public Person(String n, int a) {
//		this.name = n;
//		this.age = a;
//	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String toString() {
		return name + ":" + age;
	}
}