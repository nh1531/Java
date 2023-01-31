package edu;


public class Test38_1 {

	public static void main(String[] args) {
		int [][] arr = new int [5][5];
		
//		int num = 1;
		for (int i = 0; i<arr.length; i++)
			for(int j = 0; j<arr[i].length; j++) {
				// 난수 생성 ?
				double rnum = Math.random();
				int num = (int) (rnum * 10);

				arr[i][j] = num++;			
		}
		
		// Test38 값에서 대각선 값만 출력 
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				if(i == j)
					System.out.print(" " + arr[i][j]); // 1 7 13 19 25
			}
		// 대각선의 왼쪽 하단값만 출력
//				if(i > j)
//					System.out.println(" " + arr[i][j]); 
				
		}
	}
}
