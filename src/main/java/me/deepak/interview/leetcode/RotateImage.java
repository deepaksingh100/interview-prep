package me.deepak.interview.leetcode;

/*
 * https://leetcode.com/problems/rotate-image/
 * https://leetcode.com/problems/rotate-image/discuss/18872/A-common-method-to-rotate-the-image
*/
public class RotateImage {

	public void rotate(int[][] matrix) {
		int row = matrix.length;
		int col = matrix[0].length;
		int lastRow = row - 1;

		// reverse matrix by row
		for (int i = 0; i < row / 2; i++) {
			for (int j = 0; j < col; j++) {
				swap(matrix, i, j, lastRow, j);
			}
			lastRow--;
		}

		// swap values around top-left -- bottom-right diagonal
		for (int i = 0; i < row; i++) {
			for (int j = i + 1; j < col; j++) {
				swap(matrix, i, j, j, i);
			}
		}

	}

	private static void swap(int[][] matrix, int row1, int col1, int row2, int col2) {
		int temp = matrix[row1][col1];
		matrix[row1][col1] = matrix[row2][col2];
		matrix[row2][col2] = temp;
	}

}
