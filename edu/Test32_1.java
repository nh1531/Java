package edu;

public class Test32_1 {
	public static void main(String[] args) {
		int [] arr = new int [10];
		System.out.println(arr.length);
	
		// for (int i = 0; i<arr.length; i++)
		// System.out.println(" " + arr[i]);
		
		// 위의 두줄(8-9) 대신 이 밑의 두줄로 간단하게 만듦
		// 개수만큼 다 돌림. 20개 중에 10개만 돌리고 싶으면 이렇게 쓰면 안됨
		for (int num: arr)
		System.out.println(" " + num);
		
		
	
	}

}
