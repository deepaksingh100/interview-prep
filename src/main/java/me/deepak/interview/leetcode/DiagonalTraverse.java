package me.deepak.interview.leetcode;

/*
 * https://leetcode.com/problems/diagonal-traverse/
*/

public class DiagonalTraverse {

	public int[] findDiagonalOrder(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return new int[0];
		}
		boolean up = true;
		int i = 0;
		int j = 0;
		int m = matrix.length;
		int n = matrix[0].length;
		int[] res = new int[m * n];
		int count = 0;
		while (i < m - 1 || j < n - 1) {
			res[count++] = matrix[i][j];
			if (up) {
				if ((i == 0 && j == n - 1) || j == n - 1) {
					i++;
					up = !up;
				} else if (i == 0) {
					j++;
					up = !up;
				} else {
					i--;
					j++;
				}
			} else {
				if ((j == 0 && i == m - 1) || i == m - 1) {
					j++;
					up = !up;
				} else if (j == 0) {
					i++;
					up = !up;
				} else {
					j--;
					i++;
				}
			}
		}
		res[count] = matrix[i][j];
		return res;
	}
}
