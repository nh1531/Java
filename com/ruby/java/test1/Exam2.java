package com.ruby.java.test1;
class sample {
	int a; 
}
public class Exam2 {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Exam2 ex = new Exam2();
		sample s = new sample();
		// 3줄 private int a; 일경우 13줄 오류
		s.a = 10; 
		
	}

}

// 이런 방식으로 씀
// class 안에 class 넣지 않음