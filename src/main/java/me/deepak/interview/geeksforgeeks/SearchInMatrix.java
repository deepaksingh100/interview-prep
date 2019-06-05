package me.deepak.interview.geeksforgeeks;

/*
 * https://practice.geeksforgeeks.org/problems/search-in-a-matrix/0
*/
public class SearchInMatrix {

	private SearchInMatrix() {
	}

	public static int[] search(int[][] matrix, int key) {
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

	private static int binarySearch(int[] a, int key) {
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
