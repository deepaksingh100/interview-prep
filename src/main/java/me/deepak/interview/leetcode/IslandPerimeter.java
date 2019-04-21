package me.deepak.interview.leetcode;

/*
 * https://leetcode.com/problems/island-perimeter/
*/

public class IslandPerimeter {

	public int islandPerimeter(int[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}
		int row = grid.length;
		int col = grid[0].length;
		int perimeter = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (grid[i][j] == 1) {
					perimeter += (4 - getNeighbourCount(grid, i, j));
				}
			}
		}
		return perimeter;
	}

	private int getNeighbourCount(int[][] grid, int i, int j) {
		int row = grid.length;
		int col = grid[0].length;
		int count = 0;
		if (i > 0 && grid[i - 1][j] == 1) {
			count++;
		}
		if (j > 0 && grid[i][j - 1] == 1) {
			count++;
		}
		if (i < row - 1 && grid[i + 1][j] == 1) {
			count++;
		}
		if (j < col - 1 && grid[i][j + 1] == 1) {
			count++;
		}
		return count;
	}

}
