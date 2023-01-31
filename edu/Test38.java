package edu;

public class Test38 {

	public static void main(String[] args) {
		int [][] arr = new int [5][5];
		int num = 1;
		for (int i = 0; i<arr.length; i++) {
			for(int j = 0; j<arr[i].length; j++) {
				arr[i][j] = num++;
			}
		}
	
// 이렇게 써도 됨 { } 사이 문장이 1개일 경우 {} 생략 가능
//		for (int i = 0; i<arr.length; i++)
//			for(int j = 0; j<arr[i].length; j++)
//				arr[i][j] = num++;
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j]);
				System.out.print("\t");
				
			}
			System.out.print("\n"); // 다음줄로 내려감
		}

	}

}
