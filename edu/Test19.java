package edu;

public class Test19 {
	// p.107 if~else 문
	
	public static void main(String[] args) {
		int score = 90;
		String result = "";
		
		if(score >= 60) { // if-else 사이에 코드가 한줄(-> ;이 한개여야 함)이면 괄호{} 생략가능
			result = "합격"; // 변수 result에 합격이란 값을 넣어줌
		}
		else {
			result = "불합격";
		}
		System.out.println(result); // 출력
		
	}

}
