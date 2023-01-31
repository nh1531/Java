package edu.mission;

// 행렬 곱
public class Array {
	public static void printArray(int[][] arr) {
		for (int i = 0 ; i < arr.length ; i++) {
			for (int j = 0 ; j < arr[0].length ; j++) {
				System.out.println(arr[i][j] + "");
			}
			System.out.print("\n");
		}
	}
	
	public static void main(String[] args) {
		int [][] a = {  { 1, 2, 3, 4 },
						{ 5 ,6, 7, 8 },
						{ 9, 10, 11, 12 }	};
		int [][] b = {  { 1, 2, 3 },
						{ 4 ,5, 6 },
						{ 7, 8, 9 },
						{ 10, 11, 12 } 	};
		int [][] c = new int[3][3];
		
		printArray(a);
		System.out.print("\n");
		printArray(b);
		System.out.print("\n");
		
		for(int i = 0; i< a.length; i++) {
			for(int j = 0; j < b[0].length; j++) {
				for (int k = 0 ; k <b.length ; k++) {
					c[i][j] += a[i][k]*b[k][j];
				}
			}
		}
		printArray(c);
		
	}

}
