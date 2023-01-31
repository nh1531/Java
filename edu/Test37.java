package edu;

//p.155
public class Test37 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] score = {90, 85, 60, 100, 70};
		int sum = 0;
		double avg = 0.0;
		int max = 0;
		int min = 999; // 큰 수를 넣고 이거보다 작은 수면 그걸로 바꿈
		
		for(int i = 0; i< score.length; i++) {
			sum += score[i];
			if(max < score[i])
				max = score[i];
			
			if(min > score[i]) // score가 작으면
				min = score[i]; // min을 바꿔라
		}
		
		avg = sum / score.length;
		System.out.println( "총점 : " + sum);
		System.out.println("평균 : " + avg);
		System.out.println("최댓값 : " + max);
		System.out.println("최솟값 : " + min);

	}

}
