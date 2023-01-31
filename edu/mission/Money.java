package edu.mission;

public class Money {
	// 천원 미만은 할인하고 임의의 금액을 지불하기 위해 필요한 지폐 장수 구하기
	public static void main(String[] args) {
		
		int a = 50000;
		int b = 10000;
		int c = 5000;
		int d = 1000;
		
		// 값을 입력
		int tot = 177000;
		
		// 5만원권 몇 장 필요한지 계산
		int cnt50 = tot/a;
		System.out.println("5만원권 : "+cnt50);
		
		// 나머지 금액 계산
		tot = tot - a*cnt50;
		System.out.println("나머지 금액 : "+ tot);
		 
		
		// 1만원권 계산
		int cnt10 = tot/b;
		System.out.println("1만원권 : "+cnt10);
		
		// 나머지 금액 계산
		tot = tot - b*cnt10;
		
		// 5천원권 계산
		int cnt5 = tot/c;
		System.out.println("5천원권 : "+cnt5);
		
		// 나머지 금액 계산
		tot = tot - c*cnt5;
		
		// 1천원권 계산
		int cnt1 = tot/d;
		System.out.println("1천원권 : "+cnt1);
		
		
	}

}
