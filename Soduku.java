package Recursion;
public class Soduku {
	public static void main(String[] args) {
		int[][] a={ 	    {8, 0, 0, 0, 0, 0, 0, 0, 0},
				    {0, 0, 3, 6, 0, 0, 0, 0, 0},
				    {0, 7, 0, 0, 9, 0, 2, 0, 0},
				    {0, 5, 0, 0, 0, 7, 0, 0, 0},
				    {0, 0, 0, 0, 4, 5, 7, 0, 0},
				    {0, 0, 0, 1, 0, 0, 0, 3, 0},
				    {0, 0, 1, 0, 0, 0, 0, 6, 8},
				    {0, 0, 8, 5, 0, 0, 0, 1, 0},
				    {0, 9, 0, 0, 0, 0, 4, 0, 0}
	};
		backtracking(a, 0, 0);
	}

	public static void backtracking(int[][] a, int x, int y) {
		if (y == 9) {
			if (x == 8)
				print(a);
			else
				backtracking(a, x + 1, 0);
		} else {
			if (a[x][y] == 0) {
				for (int k = 1; k <= 9; k++) {
					if (checkS(a, x, y, k)) {
						a[x][y] = k;
						backtracking(a, x, y + 1);
						a[x][y] = 0;
					}
				}
			} else
				backtracking(a, x, y + 1);
		}
	}
	public static void print(int[][] a) {
		for(int i = 0 ; i < 9 ;i++) {
			for(int j = 0 ; j < 9 ; j++)
				System.out.print(a[i][j] + " ");
			System.out.println();
		}
	}
	public static boolean checkS(int[][] a, int x, int y, int k) {
		for(int i = 0 ; i < 9 ; i++)
			if(a[x][i] == k || a[i][y] == k) return false;
		for(int i = x - x%3 ; i <= x - x%3 + 2 ; i++) {
			for(int j = y - y%3 ; j < y - y%3 + 2 ; j++)
				if(a[i][j] == k) return false;
		}
		return true;
	}
}
