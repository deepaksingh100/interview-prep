package me.deepak.interview.geeksforgeeks;

/*
 * https://www.geeksforgeeks.org/print-kth-element-spiral-form-matrix/
*/
public class KthElementSpiralMatrix {

	private KthElementSpiralMatrix() {
	}

	public static int findK(int[][] matrix, int rowStart, int columnStart, int i, int j, int k) {

		// i is row count & j is column count
		if (i < 1 || j < 1) {
			return -1;
		}

		/* ..........If element is in outermost ring ....... */
		/* Element is in first row */
		if (k <= j) {
			return matrix[rowStart][k - 1];
		}

		/* Element is in last column */
		if (k <= (j + i - 1)) {
			return matrix[k - j][j - 1];
		}

		/* Element is in last row */
		if (k <= (j + i - 1 + j - 1)) {
			return matrix[i - 1][j - 1 - (k - (j + i - 1))];
		}

		/* Element is in first column */
		if (k <= (j + i - 1 + j - 1 + i - 2)) {
			return matrix[i - 1 - (k - (j + i - 1 + j - 1))][columnStart];
		}

		/* ..........If element is NOT in outermost ring ....... */
		// Recursion for sub-matrix.
		return findK(matrix, rowStart + 1, columnStart + 1, i - 2, j - 2, k - (2 * i + 2 * j - 4));

	}

}
