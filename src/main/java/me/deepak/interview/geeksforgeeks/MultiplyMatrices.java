package me.deepak.interview.geeksforgeeks;

/*https://practice.geeksforgeeks.org/problems/multiply-matrices/1
 *
*/

public class MultiplyMatrices {

	public void multiply(int first[][], int second[][], int result[][], int n) {
		int firstRows = first.length;
		int firstCols = first[0].length;
		int secondCols = second[0].length;
		for (int i = 0; i < firstRows; i++) {
			for (int j = 0; j < secondCols; j++) {
				for (int k = 0; k < firstCols; k++) {
					result[i][j] += first[i][k] * second[k][j];
				}
			}
		}
	}

}
