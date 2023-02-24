package 자료구조5;

public class Miro {
	
	 public static void solveMiro(int[][] array) {
		 int[][] miro = new int[array.length + 2][array.length+2];
		 
		 for(int i = 0; i <miro.length; i++) {
			 for(int j = 0 ; j < miro.length; j++) {
				 miro[i][j] = 1;
			 }
		 }
		 
		 
		 
		 for(int i = 0; i<array.length; i++) {
			 for(int j = 0; j<array.length; j++ ) {
				 miro[i+1][j+1] = array[i][j];
			 }
		 }
		 
		 for(int i = 0; i <miro.length; i++) {
			 for(int j = 0 ; j < miro.length; j++) {
				 System.out.print(miro[i][j] + " ");
			 }
			 System.out.println();
		 }
		 
	 }
	 public static void print(int[][] array) {
		 
		 
		 
	 }
	 
	 
	 
	
	public static void main(String[] args) {
		
		int[][] input = {
				{ 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1 },
				{ 1, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1, 1 },
				{ 0, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1 },
				{ 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 0 },
				{ 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1 },
				{ 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1 },
				{ 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1 },
				{ 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1 },
				{ 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1 },
				{ 1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0 },
				{ 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 },
				{ 0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0 }
				};
		
		solveMiro(input);
	}

}
