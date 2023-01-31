package edu.mission;

// 구구단
public class Gugudan {
	
	public static void main(String[] args) {
		
		
		gugu1();
		System.out.println("===========");
		gugu2();
		
	
	}
	
	public static void gugu1() {
	
		for(int i=2; i<10; i++) {
			for(int j=1; j<10; j++) {
				System.out.println(i + "*" + j + "=" + i*j);
			}
		}
	}
	
	public static void gugu2() {
		for(int i=2; i<10; i++) {
			for(int j=1; j<10; j++) {
				for(int k=0; k<col; k++) {
					
					if(10 <= i+k) {
						System.out.println("\n");
						break;
					}
					
					System.out.printf("%d*%d=%2d", (i+k), j, (i+k)*j);
					
					if(k < col-1) System.out.println("\t");
					else			System.out.println("\n");
				}
				
			}
		}
		
	}



}
