package me.deepak.interview.dynamic_programming;

/*
 * https://leetcode.com/problems/unique-paths-ii/
 * https://leetcode.com/problems/unique-paths-ii/discuss/23250/Short-JAVA-solution
*/
public class UniquePaths2 {

	public int uniquePaths(int[][] grid) {

		int row = grid.length;
		int col = grid[0].length;

		int[][] paths = new int[row][col];

		for (int i = 0; i < row; i++) {
			if (grid[i][0] == 1) {
				while (i < row) {
					paths[i++][0] = 0;
				}
			} else {
				paths[i][0] = 1;
			}
		}

		for (int i = 0; i < col; i++) {
			if (grid[0][i] == 1) {
				while (i < col) {
					paths[0][i++] = 0;
				}
			} else {
				paths[0][i] = 1;
			}
		}

		for (int i = 1; i < row; i++) {
			for (int j = 1; j < col; j++) {
				if (grid[i][j] == 0) {
					paths[i][j] = paths[i][j - 1] + paths[i - 1][j];
				} else {
					paths[i][j] = 0;
				}
			}
		}
		return paths[row - 1][col - 1];
	}

	public int uniquePathsSpaceOptimized(int[][] grid) {

		int col = grid[0].length;
		int[] paths = new int[col];
		paths[0] = 1;
		for (int[] row : grid) {
			for (int j = 0; j < col; j++) {
				if (row[j] == 1) {
					paths[j] = 0;
				} else if (j > 0) {
					paths[j] += paths[j - 1];
				}
			}
		}
		return paths[col - 1];
	}

}
