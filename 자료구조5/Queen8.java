package 자료구조5;

import 자료구조5.Stack.EmptyGenericStackException;

//* 문제 해결형 자바 코딩 실습이 필요
//- main()의 작성 방법 훈련 - 
//main() {
//	int [][]data;
//	배열 초기화
//	SolveQueen(data);
//	배열열 출력: 8개의 queen 배치(여러가지 해를 구해 보여주기)
//}
//- 함수 호출로 구현 훈련
//  void SolveQueen(int [][]d) {
//     //코딩 완성하기 
//  }
//=> 8  Queen 문제 풀기: 스택 사용하여 backtracking 코딩 실습
//  -> 2차원 배열에 0으로 초기화, Queen을 배치하면 1로 설정, 8 X 8 배열에 8개 퀸이 가로 세로 대각선에 충돌이 없으면 성공
//
//  -> stack에 Point 객체를 생성하여 push, pop::(x, y, move) => move는 다음 이동 가능 candidate의 column임
//      class MyStack {
//	int top;
//	Point [] data
//	void Push(Point p);
//	Point Pop();
//       }

class Point {
	private int ix;
	private int iy;

	public Point(int x, int y) {
		ix = x;
		iy = y;
	}

	public String toString() {
		return "<" + ix + ", " + iy + ">";
	}

	public int getX() {
		return ix;
	}

	public int getY() {
		return iy;
	}

	public void setX(int x) {
		ix = x;
	}

	public void setY(int y) {
		iy = y;
	}
}

class MyStack {
	// --- 실행시 예외: 스택이 비어있음 ---//
	// generic class는 Throwable을 상속받을 수 없다 - 지원하지 않는다
	public class EmptyGenericStackException extends Exception {
		private static final long serialVersionUID = 1L;

		public EmptyGenericStackException() {
			super();
		}
	}

	// --- 실행시 예외: 스택이 가득 참 ---//
	public class OverflowGenericStackException extends RuntimeException {
		public OverflowGenericStackException() {
		}
	}

	private Point data[]; // 스택용 배열
	// private List<T> data;
	private int capacity; // 스택의 크기
	private int top; // 스택 포인터

//--- 생성자(constructor) ---//
	public MyStack(int capacity) {
		top = 0;
		this.capacity = capacity;
		// this.data = new T[capacity]; // 스택 본체용 배열을 생성
		try {
			data = new Point[capacity];
		} catch (OutOfMemoryError e) {
			capacity = 0;
		}
	}

//--- 스택에 x를 푸시 ---//
	public Point push(Point x) throws OverflowGenericStackException {
		System.out.println("top = " + top + "capacity = " + capacity);
		if (top >= capacity)
			throw new OverflowGenericStackException();
		return data[top++] = x;

	}

//--- 스택에서 데이터를 팝(정상에 있는 데이터를 꺼냄) ---//
	public Point pop() throws EmptyGenericStackException {
		if (top <= 0)
			throw new EmptyGenericStackException();
		return data[--top];
	}

//--- 스택에서 데이터를 피크(peek, 정상에 있는 데이터를 들여다봄) ---//
	public Point peek() throws EmptyGenericStackException {
		if (top <= 0)
			throw new EmptyGenericStackException();
		return data[top - 1];
	}

//--- 스택을 비움 ---//
	public void clear() {
		top = 0;
	}

//--- 스택에서 x를 찾아 인덱스(없으면 –1)를 반환 ---//
	public int indexOf(Point x) {
		for (int i = top - 1; i >= 0; i--) // 꼭대기 쪽부터 선형 검색
			if (data[i].equals(x))
				return i; // 검색 성공
		return -1; // 검색 실패
	}

//--- 스택의 크기를 반환 ---//
	public int getCapacity() {
		return capacity;
	}

//--- 스택에 쌓여있는 데이터 갯수를 반환 ---//
	public int size() {
		return top;
	}

//--- 스택이 비어있는가? ---//
	public boolean isEmpty() {
		return top <= 0;
	}

//--- 스택이 가득 찼는가? ---//
	public boolean isFull() {
		return top >= capacity;
	}

//--- 스택 안의 모든 데이터를 바닥 → 꼭대기 순서로 출력 ---//
	public void dump() {
		if (top <= 0)
			System.out.println("stack이 비어있습니다.");
		else {
			for (int i = 0; i < top; i++)
				System.out.print(data[i] + " ");
			System.out.println();
		}
	}
}

public class Queen8 {
	int r = 8;
	int c = 8;
	int [][] arr = new int [r][c];
	
	
	static int NextMove(int[][] d, int x, int y){ // current row에 대한 다음 배치 가능한 모든 column을 조사하고 move[]에 1로 설정
		while ( y < d.length) { 
		 if (CheckMove(d,x,y)) return y;
		 y++;
		}
		
		return -1;
	}


	static boolean CheckMove(int [][] d, int x, int y){ // currentRow에 대하여 queen을 (x,y)에 배치 가능하면 true
		if(!checkRow(d, x))
			return false;
		if(!checkCol(y))
			return false;
		if (!checkDiagSW(x, y))
			return false;
		if (!checkDiagSE(x, y))
			return false;
		
		return true;
	}

//
// => backtracking을 stack을 이용하여 push/pop으로 해결하는 것을 보이는 것임
//
//-> 가로, 세로, 대각선에 대한 충돌 체크 함수 코딩
	//boolean CheckMove(int[][] d, int x, int y) {
	//}

	static boolean checkRow(int [][] d, int x) {
		for (int i = 0; i < x; i++) {
			if (d[x][i] == 1)
				return false;
		}
		return true;
	}

	static boolean checkCol(int [][] d, int y) {
		for (int i = 0; i < y; i++) {
			if (d[i][y] == 1)
				return false;
		}
		return true;
	}

	static boolean checkDiagSW(int x, int y) {
		// x++, y-- or x--, y++ where 0<= x,y <= 7 대각선 sw
		while() {
			
		}
		while() {
			
		}
		return true;
	}

	static boolean checkDiagSE(int x, int y) {
		// x++, y++ or x--, y-- 대각선 se
		return true;
	}
	

	public static void SolveQueen(int[][] d) {
		int nextCol = 0;
		int counter = 0;
		Point p = new Point(x, y);
		Stack s = new Stack(50);
		int x = 0, y = 0;
		s.push(p);
		while (x < 8) {
			x++;y = 0;
			y = NextMove(d, x, y);
			// 다음줄에 넣을 곳이 없으면
			if (y == -1) {
				
				try {
					p = s.pop();
				} catch (EmptyGenericStackException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
		        }
			}
			// 넣을 수 있을 때
			else {
				
				p = s.push(p);
				//OverflowGenericStackException
			}
			nextCol = NextMove(d, x, y);
		}

	}

	public static void main(String[] args) {
		int row = 8, col = 8;
		int[][] data = new int[8][8];

		// 배열 초기화
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data.length; j++) {
				data[i][j] = 0;
			}
		}

		SolveQueen(data);

	}

}