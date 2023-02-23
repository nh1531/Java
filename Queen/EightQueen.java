package Queen;

class Point{
	private int x;
	private int y;
	
	public Point (int x, int y) {
		// this.x -> Point 안에 선언한 private x
		this.x = x;
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
}

class MyStack{
	private int top;
	private Point[] data;
	
	public MyStack() {
		top = 0;
		data = new Point[100];
	}
	public boolean isEmpty() {
		if(top == 0)
			return true;
		else 
			return false;
	}
	
	public void push(Point p) {
		data[top++] = p; //top 0번째 넣고 p를 넣음
	}
	public Point pop() {
		return data[--top]; 
	}
}

public class EightQueen {
	public static boolean checkMove(int x, int y, int[][] array) { //가로, 세로, 대각선
		if(!(checkRow(x, array))) return false;
		if(!(checkCol(y, array))) return false;
		if(!(checkDiagSW(x, y, array))) return false;
		if(!(checkDiagSE(x, y, array))) return false;
		
		return true;
	}
	public static boolean checkDiagSE(int x, int y, int[][] array) { // / 
		int dx = x;
		int dy = y;
		//올라감
		while (dx >= 0 && dx <array[y].length && dy >= 0 && dy <array[x].length) {
			if(array[dx][dy] == 1)
				return false;
			dx++;
			dy--;
		}
		// 초기화
		dx = x;
		dy = y;
		// 내려감
		while (dx >= 0 && dx <array[y].length && dy >= 0 && dy <array[x].length) {
			if(array[dx][dy] == 1)
				return false;
			dx--;
			dy++;
		}
		return true;
	}
	
	public static boolean checkDiagSW(int x, int y, int[][] array) { 
		int dx = x;
		int dy = y;
		
		while (dx >= 0 && dx <array[y].length && dy >= 0 && dy <array[x].length) {
			if(array[dx][dy] == 1)
				return false;
			dx++;
			dy--;
		}
		
		dx = x;
		dy = y;
		
		while (dx >= 0 && dx <array[y].length && dy >= 0 && dy <array[x].length) {
			if(array[dx][dy] == 1)
				return false;
			dx--;
			dy++;
		}
		return true;
		
	}
	
	public static boolean checkCol(int y, int[][] array) { // 
		for(int i = 0; i < array[y].length; i++) {
			if(array[i][y] == 1)
				return false;
		}
		return true;
	}
	
	public static boolean checkRow(int x, int[][] array) { // x 고정 y만 검사
		for(int i = 0; i < array[x].length; i++) {
			if(array[x][i] == 1)
				return false;
		}
		return true;
	}
	
	public static void solveQueen(int row, int col, int[][] array) {
		MyStack s = new MyStack();
		Point p = new Point(0,0);
		
		int x = p.getX();
		int y = p.getY();
		int flag = 0;
		while(true) {
			while(x < row) {
				while(y < col) {
					if(checkMove(x, y, array)) {
						array[x][y] = 1;
						//Point p1 = new Point(x,y);
						//s.push(p1); // p.setX(p1);
						s.push(new Point(x,y));
						y = 0;
						break;
					}
					y++; // 못찍었으면 y 증가 
				}
				
				x++; // 찍었으면 다음줄로
				if(y >= col) { // y가 칸을 벗어나면
					if(!s.isEmpty()) { // 갈 곳이 있으면
						p = s.pop();
						x = p.getX();
						y = p.getY();
						array[x][y] = 0;
						y++;
					}
					else {		
						flag = 1;
						break;
					}
				}
			}
			//if(s.isEmpty()) break;
			if(flag == 1) break;
			printBoard(row, col, array);
			p = s.pop();
			x = p.getX();
			y = p.getY();
			array[x][y] = 0;
			y++;
		}
		
		
		
		
	}
	static int num = 0;
	public static void printBoard(int row, int col, int[][] array) {
		System.out.println(++num);
		for(int i = 0; i < array.length; i++ ) {
			for(int j =0; j < array.length; j++) {
				System.out.print(array[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		int row = 4;
		int col = 4;
		int[][] array = new int[row][col];
		
		// 배열 초기화
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				array[i][j] = 0;
			}
		}
		
		solveQueen(row, col, array);
		
		
	}

}
