package edu.mission;

import java.util.Scanner;

public class FreeFall {
	// 자유 낙하 물체의 위치 구하기

	public static void main(String[] args) {

/*		double initht = 1000.0; // 떨어지기전 최초 높이
		int t = 5; // 5초
		double g = 9.81; // 중력 가속도
		
		// 등가속 운동 물체의 위치 공식 : 1/2 * 가속도 * 이동시간의 제곱 + 초기 속도 + 초기 위치
		double dist = g * t * t / 2; 
		double ht = initht - dist; // 5초 후의 위치 = 1000m - 떨어진 위치
		System.out.println(t + "초 후 위치 : " + ht + "m");
*/
		double initht = 1000.0;
		double g = 9.81;
		
		for(int t=0; t>=0; t++) {
			
			double dist = g * t * t / 2; 
			double ht = initht - dist;
			if(ht<0.0) {
				break;
			}
			System.out.println(t+"초 후 위치 : " + ht + "m");			
		}

	}

}
