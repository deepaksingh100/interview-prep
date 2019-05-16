package me.deepak.interview.leetcode;

/*
 * https://leetcode.com/problems/diagonal-traverse/
*/
public class DiagonalTraverse {

	public int[] findDiagonalOrder(int[][] matrix) {

		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return new int[0];
		}

		// true if going up
		boolean up = true;

		// row iterator
		int i = 0;

		// column iterator
		int j = 0;

		// row count
		int m = matrix.length;

		// column column
		int n = matrix[0].length;

		// result array
		int[] res = new int[m * n];

		// result array iterator
		int count = 0;

		while (i < m - 1 || j < n - 1) {

			res[count++] = matrix[i][j];

			if (up) {

				if (j == n - 1) {

					// if reached at last column, increase row index, change direction to down
					i++;
					up = !up;
				} else if (i == 0) {

					// if reached at first row, increase column index, change direction to down
					j++;
					up = !up;
				} else {

					// else decrease row index, increase column index
					i--;
					j++;
				}
			} else {

				if (i == m - 1) {

					// if reached at last row, increase column index, change direction to up
					j++;
					up = !up;
				} else if (j == 0) {

					// if reached at first column, increase row index, change direction to up
					i++;
					up = !up;
				} else {

					// else decrease column index, increase row index
					j--;
					i++;
				}
			}
		}
		res[count] = matrix[i][j];
		return res;
	}
}
