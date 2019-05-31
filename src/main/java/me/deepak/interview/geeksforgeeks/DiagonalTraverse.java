package me.deepak.interview.geeksforgeeks;

public class DiagonalTraverse {

	private DiagonalTraverse() {
	}

	/*
	 * https://www.geeksforgeeks.org/zigzag-or-diagonal-traversal-of-matrix/
	 */
	public static int[] traverseDiagonalToUp(int[][] matrix) {
		// row count
		int m = matrix.length;

		// column column
		int n = matrix[0].length;

		// m + n - 1 is number of diagonals
		int[] traversal = new int[m + n - 1];

		// start from first column
		for (int k = 0; k < m; k++) {
			int i = k;
			int j = 0;
			while (i >= 0) {
				traversal[k] = matrix[i--][j++];
			}

		}

		// start from last row
		for (int k = 1; k < n; k++) {
			int i = m - 1;
			int j = k;
			while (j < n) {
				traversal[k + m - 1] = matrix[i--][j++];
			}

		}

		return traversal;

	}

	/*
	 * https://practice.geeksforgeeks.org/problems/print-diagonally/0
	 */
	public static int[] traverseDiagonalToDown(int[][] matrix) {

		// row count
		int m = matrix.length;

		// column column
		int n = matrix[0].length;

		// m + n - 1 is number of diagonals
		int[] traversal = new int[m + n - 1];

		// start from first row
		for (int k = 0; k < n; k++) {
			int i = 0;
			int j = k;
			while (j >= 0) {
				traversal[k] = matrix[i++][j--];
			}
		}

		// start from last column
		for (int k = 1; k < m; k++) {
			int i = k;
			int j = n - 1;
			while (i < m) {
				traversal[k + m - 1] = matrix[i++][j--];
			}
		}
		return traversal;
	}
}
