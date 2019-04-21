package me.deepak.interview.leetcode;

/*
 * https://leetcode.com/problems/minimum-path-sum/
*/

public class MinimumPathSum {

	public int minPathSum(int[][] costs) {
		int rows = costs.length;
		int columns = costs[0].length;
		int[][] table = new int[rows][columns];
		table[0][0] = costs[0][0];
		for (int i = 1; i < rows; i++) {
			table[i][0] = costs[i][0] + table[i - 1][0];
		}
		for (int i = 1; i < columns; i++) {
			table[0][i] = costs[0][i] + table[0][i - 1];
		}
		for (int i = 1; i < rows; i++) {
			for (int j = 1; j < columns; j++) {
				table[i][j] = Math.min(table[i - 1][j], table[i][j - 1]) + costs[i][j];
			}
		}
		return table[rows - 1][columns - 1];
	}

}
