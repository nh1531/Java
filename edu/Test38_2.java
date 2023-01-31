package edu;

public class Test38_2 {
// 행렬 실습
	
	public static void main(String[] args) {
		int [][] a = new int [3][3]; // 3 4
		int [][] b = new int [3][3]; // 4 5
		int [][] c = new int [3][3]; //c에 관한건 주석처리
		int [][] d = new int [3][3]; //3 5
		
				
		for (int i = 0; i<a.length; i++) {
			for(int j = 0; j<a[0].length; j++) {
				double rnum = Math.random();
				int num = (int) (rnum * 5); // 5 이하의 숫자만 넣는 것
				a[i][j] = num;	
			}
		}
	

		for(int i = 0; i < b.length; i++) {
			for(int j = 0; j < b[0].length; j++) {
				double rnum = Math.random();
				int num = (int) (rnum * 5);
				b[i][j] = num;	
			}
		}
		
		
				
		// 출력 a > b > c 순서
		
		System.out.println("행렬 a = ");
		for(int i = 0; i < a.length; i++) {
			for(int j = 0; j < a[0].length; j++) {
				System.out.print(a[i][j]);
				System.out.print("\t");
			}
			System.out.print("\n");
		}
		
		System.out.println();
		System.out.println("행렬 b = ");
		for(int i = 0; i < b.length; i++) {
			for(int j = 0; j < b[0].length; j++) {
				System.out.print(b[i][j]);
				System.out.print("\t");
			}
			System.out.print("\n");
		}
		
		// c = a + b 행렬 더하기
		for (int i = 0; i < a.length; i++) 
			for (int j = 0; j <a[i].length; j++) 
				c[i][j] = a[i][j] + b[i][j];
		
		System.out.println("행렬 c = ");
		for(int i = 0; i < c.length; i++) {
			for(int j = 0; j < c[i].length; j++) {
				System.out.print(c[i][j]);
				System.out.print("\t");
			}
			System.out.print("\n");
		}
		
		// d = a * b 행렬의 곱
		for(int i = 0; i < a.length; i++) {
			for(int j = 0; j < a[i].length; j++) {
				int sum = 0;
				for (int k = 0; k < a[i].length; k++ ) { 
					// sum  = sum + a[i][k] * b[k][j]
					sum  +=  a[i][k] * b[k][j];
				}
				d[i][j] = sum;
				
			}
		}
		
		System.out.println("행렬 d = ");
		for(int i = 0; i < d.length; i++) {
			for(int j = 0; j < d[i].length; j++) {
				System.out.print(d[i][j]);
				System.out.print("\t");
			}
			System.out.print("\n");
		}
		
		
		
		
		
		
		
		
		
		
		
		
//		for (int i= 0)
//			for(int j = 0)
//				for(int k = 0; k[0].length; k++) {
//					int sum = 0
//					sum += a[i,j] * b[k,j]
//				}
//			c[i,j]=sum;
					
		
		
//		for (int i = 0; i<a.length; i++) {
//			for(int j = 0; j<a[0].length; j++) {
//				System.out.print(a[i][j]);
//				System.out.print("\t");
//			}
//			System.out.print("\n");
//		}
//		
//		for (int i = 0; i<b.length; i++) {
//			for(int j = 0; j<b[0].length; j++) {
//				System.out.print(b[i][j]);
//				System.out.print("\t");
//			}
//			System.out.print("\n");
//		}
			
		
	}

}

// for(int i = 0; i <arr.length; i++) { // arr.length 배열의 갯수
//	System.out.println(arr[i]); // arr의 0번지 값 출력
//}

// 확장 for문
// for(변수 선언 : 배열 변수명) {
// 	실행문;
//}

// for(int num : arr){
// System.out.println(num);
// }