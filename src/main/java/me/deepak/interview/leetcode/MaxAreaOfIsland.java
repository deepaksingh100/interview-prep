package me.deepak.interview.leetcode;

/*
 * https://leetcode.com/problems/max-area-of-island/
*/
public class MaxAreaOfIsland {

	public int maxAreaOfIsland(int[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}

		// row length
		int m = grid.length;

		// column length
		int n = grid[0].length;

		int ans = 0;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1) {
					ans = Math.max(ans, merge(grid, i, j));
				}
			}
		}
		return ans;
	}

	private int merge(int[][] grid, int i, int j) {
		int m = grid.length;
		int n = grid[0].length;
		if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != 1) {
			return 0;
		}

		// writing an invalid value, so that we would never process this in future
		grid[i][j] = 2;

		return 1 + merge(grid, i - 1, j) + merge(grid, i + 1, j) + merge(grid, i, j - 1) + merge(grid, i, j + 1);
	}

}
