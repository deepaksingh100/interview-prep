package me.deepak.interview.leetcode;

/*
 * https://leetcode.com/problems/toeplitz-matrix/
*/
public class ToeplitzMatrix {

	public boolean isToeplitzMatrix(int[][] matrix) {
		int row = matrix.length;
		int column = matrix[0].length;
		for (int i = 0; i < row - 1; i++) {
			for (int j = 0; j < column - 1; j++) {
				if (matrix[i][j] != matrix[i + 1][j + 1]) {
					return false;
				}
			}
		}
		return true;
	}

}
