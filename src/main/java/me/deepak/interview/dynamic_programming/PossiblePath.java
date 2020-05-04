package me.deepak.interview.dynamic_programming;

/*
 * https://www.geeksforgeeks.org/check-possible-path-2d-matrix/
 * Asked in Oyo SDE-1 08-06-2019
*/
public class PossiblePath {

	private PossiblePath() {
	}

	// to find the path from top left to bottom right
	public static boolean isPath(int[][] grid) {

		int row = grid.length;
		int col = grid[0].length;

		if (grid[0][0] == -1 || grid[row - 1][col - 1] == -1) {
			return false;
		}

		// Mark reachable (from top left) nodes in first row and first column.
		for (int i = 0; i < row; i++) {
			if (grid[i][0] == -1) {
				while (i < row) {
					grid[i++][0] = -1;
				}
			}
		}

		for (int i = 0; i < col; i++) {
			if (grid[0][i] == -1) {
				while (i < col) {
					grid[0][i++] = -1;
				}
			}
		}

		// Mark reachable nodes in remaining matrix.
		for (int i = 1; i < row; i++) {
			for (int j = 1; j < col; j++) {
				if (grid[i][j] != -1) {
					grid[i][j] = Math.max(grid[i][j - 1], grid[i - 1][j]);
				}
			}
		}

		return grid[row - 1][col - 1] == 0;
	}

	public static void main(String[] args) {
		int[][] grid = { { 0, 0, 0, -1, 0 }, { -1, 0, 0, -1, -1 }, { 0, 0, 0, -1, 0 }, { -1, 0, -1, 0, -1 },
				{ 0, 0, -1, 0, 0 } };
		isPath(grid);
	}
}
