package me.deepak.interview.geeksforgeeks;

/*
 * https://www.geeksforgeeks.org/print-given-matrix-zigzag-form/
*/
public class ZigZagMatrix {

	private ZigZagMatrix() {
	}

	public static int[] zigZag(int[][] matrix) {

		int row = matrix.length;
		int column = matrix[0].length;

		int[] traversal = new int[row * column];
		int k = 0;

		for (int i = 0; i < row; i++) {

			if ((i & 1) == 0) {

				// for even row, traverse from left to right
				for (int j = 0; j < column; j++) {

					traversal[k++] = matrix[i][j];
				}
			} else {

				// for odd row, traverse from right to left
				for (int j = column - 1; j >= 0; j--) {

					traversal[k++] = matrix[i][j];
				}
			}

		}
		return traversal;
	}

}
