package me.deepak.interview.leetcode;

/*
 * https://leetcode.com/problems/search-a-2d-matrix-ii/
 * https://leetcode.com/problems/search-a-2d-matrix-ii/discuss/66140/My-concise-O(m%2Bn)-Java-solution
*/
public class Search2DMatrix2 {

	public boolean searchMatrix(int[][] matrix, int key) {

		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return false;
		}

		int i = 0;
		int j = matrix[0].length - 1;

		while (i < matrix.length && j >= 0) {
			if (key < matrix[i][j]) {
				j--;
			} else if (key > matrix[i][j]) {
				i++;
			} else {
				return true;
			}
		}
		return false;
	}

}
