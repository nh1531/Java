package com.ruby.java.ch07.inheritance;

public class Professor extends Person {
	
//	private String name;
//	private int age;
	private String subject;
	
	public Professor() {
		System.out.println("Professor 생성자 실행");
	}
	
	public Professor(String name, int age, String subject) {
		super(name, age);
//		super.setName(name);
//		super.setAge(age);
		this.subject = subject;
		System.out.println("Professor(name, age, subject) 생성자 실행");	
		
	}

	
//	public String getName() {
//		return name;
//	}
//	
//	public void setName(String name) {
//		this.name = name;
//	}
//	
//	public int getAge() {
//		return age;
//	}
//	
//	public void setAge(int age) {
//		this.age = age;
//	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
}