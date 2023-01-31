package edu.mission;

import java.util.Scanner;

// 소수 판단
public class Primecheck {
	
	public void prime(int num) {
		for(int i = 2; i < num; i++) {
			if(num%i == 0) {
				System.out.println("소수가 아님");
				return;
			}
		}	
		 System.out.println("소수"); 

		
	}

	public static void main(String[] args) {
		
		Primecheck pc= new Primecheck();
		
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Number : ");
			int num;
			while((num = sc.nextInt()) != 0) {
				pc.prime(num);
				System.out.println("Number : ");
						
			}
		}
		System.out.println("프로그램을 종료합니다.");
	}
	

}








// (num = sc.nextInt()) != 0   () 괄호로 묶으면 괄호안이 먼저 계산. 괄호값이 num.
// num = sc.nextInt();
// if (num != 0){
// }