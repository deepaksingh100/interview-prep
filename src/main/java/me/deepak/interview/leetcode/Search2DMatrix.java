package me.deepak.interview.leetcode;

/*
 * https://leetcode.com/problems/search-a-2d-matrix/
*/
public class Search2DMatrix {

	public boolean searchMatrix(int[][] matrix, int key) {

		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return false;
		}

		return search(matrix, key).length > 0;
	}

	private int[] search(int[][] matrix, int key) {
		int low = 0;
		int high = matrix.length - 1;
		int cols = matrix[0].length;
		while (low <= high) {
			int mid = (low + high) >>> 1;
			if (Math.max(matrix[mid][0], matrix[mid][cols - 1]) < key) {
				low = mid + 1;
			} else if (Math.min(matrix[mid][0], matrix[mid][cols - 1]) > key) {
				high = mid - 1;
			} else {
				int returnVal = binarySearch(matrix[mid], key);
				if (returnVal == -1) {
					return new int[0];
				}
				return new int[] { mid, returnVal };
			}
		}
		return new int[0];
	}

	private int binarySearch(int[] a, int key) {
		int low = 0;
		int high = a.length - 1;
		while (low <= high) {
			int mid = (low + high) >>> 1;
			if (a[mid] < key) {
				low = mid + 1;
			} else if (a[mid] > key) {
				high = mid - 1;
			} else {
				return mid;
			}
		}
		return -1;
	}

}
