package edu;

public class Test28 {
	// p.132 break 문 
	
	public static void main(String[] args) {
		
	int cnt = 0;
	
	while(true) {
		System.out.println("OK");
		cnt = cnt + 2;
		if(cnt == 10) {
			break; // 여기 break가 없으면 무한루프 돌게 됨
		}
	}
		
	}

}
