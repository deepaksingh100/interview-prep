package me.deepak.interview.dynamic_programming;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

	private LongestIncreasingSubsequence() {
	}

	/*
	 * https://www.geeksforgeeks.org/longest-increasing-subsequence-dp-3/
	 * https://www.youtube.com/watch?v=fV-TF4OvZpk
	 */
	public static int lisLength(int[] arr) {
		int length = arr.length;
		int[] lisLengths = new int[length];

		// Initialize LIS values for all indexes
		Arrays.fill(lisLengths, 1);

		/*
		 * Compute optimized LIS values in bottom up manner. if arr[i] > arr[j], then
		 * lis[i] = max(lis[i], lis[j] + 1)
		 * 
		 */
		for (int i = 1; i < length; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j]) {
					lisLengths[i] = Math.max(lisLengths[i], lisLengths[j] + 1);
				}
			}
		}

		// Pick maximum of all LIS values
		return Arrays.stream(lisLengths).max().getAsInt();
	}

	/*
	 * https://www.geeksforgeeks.org/construction-of-longest-increasing-subsequence-
	 * using-dynamic-programming/
	 */
	public static int[] lis(int[] arr) {
		int length = arr.length;
		int[] lisLengths = new int[length];

		// Initialize LIS values for all indexes
		Arrays.fill(lisLengths, 1);

		/*
		 * Compute optimized LIS values in bottom up manner. if arr[i] > arr[j], then
		 * lis[i] = max(lis[i], lis[j] + 1)
		 * 
		 */
		for (int i = 1; i < length; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j]) {
					lisLengths[i] = Math.max(lisLengths[i], lisLengths[j] + 1);
				}
			}
		}

		// Pick maximum of all LIS values
		int lisLength = Arrays.stream(lisLengths).max().getAsInt();

		int[] lis = new int[lisLength];

		// loop on lisLengths
		for (int i = length - 1; i >= 0; i--) {

			// if current lisLength == lisLengths[i], add it to lis
			if (lisLengths[i] == lisLength) {
				lis[--lisLength] = arr[i];
			}
		}
		return lis;
	}

	public static void main(String[] args) {
		int[] arr = { 10, 22, 9, 33, 21, 50, 41, 60 };
		int[] lis = lis(arr);
		System.out.println("LIS length is = " + lisLength(arr));
		for (int i : lis) {
			System.out.print(i + " ");
		}
	}

}
