package edu;

public class Test16 {
	// p.93 타입 캐스팅
	
	public static void main(String[] args) {
		
		byte a = 23;
		int b = a;
		System.out.println(b);
		
		byte c = 23;
		short d = 47;
		int e = 65;
		int f = c + d + e;
		System.out.println(f);
		
		int g= 23;
		byte h = (byte) g;
		System.out.println(h);
		
		byte i = 10;
		byte j = 20;
		byte k = (byte) (i + j);
		System.out.println(k);
		
		int l = 132;
		byte m = (byte)l;
		System.out.println(m); // overflow
	}

}
