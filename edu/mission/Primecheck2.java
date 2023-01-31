package edu.mission;

import java.util.Scanner;

// 소수 판단
public class Primecheck2 {
	
	public static boolean prime(int num) {
		System.out.println("입력 숫자 : " + num);
		for(int i = 2; i < num; i++) {
			if(num%i == 0) 	return false;
		}	
		return true;
	}

	public static void main(String[] args) {
		
//		for (int i = 0 ; i < args.length ; i++)
//			System.out.println("args" + i + ":" + args[i]);
		
		int num = Integer.parseInt(args[0]); 
		if(prime(num) == true)
			System.out.println("Prime");
		else
			System.out.println("Not Prime");
		
		System.out.println("Done");
	}
	

}

