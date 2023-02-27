package 자료구조5;
import java.util.Stack;


class items {
	int x, y;
	int dir;

	public items(int x, int y, int dir) {
		this.x = x;
		this.y = y;
		this.dir = dir;
	}
};

class offsets { // -1, 0, 1 값
	int a, b;
}

public class Maze {

	static offsets[] moves = new offsets[8];
	static int maze[][] = new int[100][100];
	static int[][] mark = new int[100][100];

	static void path(int m, int p) {

// Output a path (if any) in the maze; rows is m, cols is p;

		mark[1][1] = 1;
		Stack<items> stack = new Stack<>();
		items temp = new items(0, 0, 0);
		temp.x = 1;
		temp.y = 1;
		temp.dir = 2; // E
		stack.push(temp);

		while (!stack.isEmpty()) // stack not empty
		{
			temp = stack.pop(); // unstack
			int i = temp.x;
			int j = temp.y;
			int d = temp.dir;
			while (d < 8) // moves forward
			{
				int g = i + moves[d].a;
				int h = j + moves[d].b;
				if ((g == m) && (h == p)) { // reached exit
											// output path
					/// cout << stack;

					System.out.println("the term near the exit: " + i + " " + j);
					System.out.println("exit:" + m + " "+ n);
					return;
				}
				if ((maze[g][h] == 0) && (mark[g][h]) == 0) { // new position
					mark[g][h] = 1;
					// Because the neighbor in the direction of d has been checked.
					temp.x = i;
					temp.y = j;
					temp.dir = d + 1;
					stack.push(temp); // stack it
					i = g;
					j = h;
					d = 0; // N moves to (g,h)
				} else
					d++; // try next direction
			}
		}
		System.out.println("no path in maze ");
	}

	public static void main(String[] args) {

		int[][] input = { { 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1 },
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
				{ 0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0 } };

		moves[0].a = -1;
		moves[0].b = 0;
		moves[1].a = -1;
		moves[1].b = 1;
		moves[2].a = 0;
		moves[2].b = 1;
		moves[3].a = 1;
		moves[3].b = 1;
		moves[4].a = 1;
		moves[4].b = 0;
		moves[5].a = 1;
		moves[5].b = -1;
		moves[6].a = 0;
		moves[6].b = -1;
		moves[7].a = -1;
		moves[7].b = -1;

		for (int i = 0; i < 14; i++) {
			for (int j = 0; j < 17; j++) {
				if ((i == 0) || (j == 0) || (i == 13) || (j == 16))
					maze[i][j] = 1;
				else {
					maze[i][j] = input[i - 1][j - 1];
				}
				;
				mark[i][j] = 0;

			}
		}
		for (int i = 0; i <= 13; i++) {
			for (int j = 0; j <= 16; j++) {				
				System.out.println(maze[i][j] + " "); 
			}

				path(12, 15);

		}
	}
}
