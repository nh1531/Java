package com.ruby.java.test1;

public class Armor {
	private String name;
	private int height;
	private int weight;
	private String color;
	private boolean isFly;
	double speed;
	
	public String getName() {
		return name;
	}
	
//	public void setHeight (int value) {
//		height = value;
//	}
	
	
	public void speedUp(double value) {
		speed = value;
	}
	
	public void speedUp(double value, int maxValue) {
		double speed = value;
		int maxSpeed = maxValue;
	}
	
	public void setHeight(int value) {
		height = value;
	}
	
	public void setName() {
		String value = "mark6";
		name = value;
	}
	
	public boolean takeOff() {
		System.out.println("엔진을 시동하다");
		System.out.println("엔진 시동이 실패하다");
		return false;
	}
	
	public int takeOff(int value) {
		System.out.println("엔진 시동 : value =" + value);
		return value -50;
	}
	
}
