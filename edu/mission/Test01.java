package edu.mission;

// 최대공약수, 최소공배수
public class Test01 {
	
	public static void main(String[] args) {

		int a = 12;
		int b = 18;
		int rem = 0;
		int max = 0;
		int min = 0;
		
		if(a > b) {
			max = a;
			min = b;
			
		} else {
			max = b;
			min = a;
		}
		
		
		while(true) {
			rem = max%min;
			
			if(rem == 0) {
				break;
			}
			
			max = min;
			min = rem;
			
		}
		System.out.println(min);
		System.out.println(a*b / min);
		
//		while(rem != 0) {
//			
//			max = min;
//			min = rem;
//			
//			rem = max%min;	
//		}
//		
//		System.out.println(min);
//		System.out.println(a*b / min);
		
		
		
		
		
		
	}

}
