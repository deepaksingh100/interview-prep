package me.deepak.interview.geeksforgeeks;

/*
 * https://www.geeksforgeeks.org/c-program-multiply-two-matrices/
*/

public class MultiplyMatrices {

	public void multiply(int[][] first, int[][] second, int[][] result) {
		int row1Count = first.length;
		int column1Count = first[0].length;
		int column2Count = second[0].length;
		for (int i = 0; i < row1Count; i++) {
			for (int j = 0; j < column2Count; j++) {
				for (int k = 0; k < column1Count; k++) {
					result[i][j] += first[i][k] // traversing first matrix row wise
							* second[k][j]// traversing second matrix column wise
					;
				}
			}
		}
	}

}
