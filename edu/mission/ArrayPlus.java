package edu.mission;

// 배열 합치기
public class ArrayPlus {
	
	public static void merge(int[] arr) {
		for(int p = 0 ;  p < arr.length ; p++) {
			System.out.print(arr [p]);
			System.out.print("\t");
			
		}
			
 	}
	
	public static void main(String[] args) {
		int[] a = { 1, 3, 5, 7 };
		int[] b = { 2, 4, 6, 8 };
		int[] c = new int [a.length * 2];
		
		for (int i = 1; i <a.length+1 ; i++) {
			c[2*i-2]=a[i-1];
			c[2*i-1]=b[i-1];
		}
		
		
		merge(c);
		
		
	}
}

// void sum (int a, int b){ 
// }
// sum (10, 20);
