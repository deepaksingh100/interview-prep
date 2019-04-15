package me.deepak.interview.dynamic_programming;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		int[] arr = { 10, 22, 9, 33, 21, 50, 41, 60 };
		int[] lis = lis(arr);
		for (int i : lis) {
			System.out.println(i);
		}
		// System.out.println("Length of lis is " + lisLength(arr));
	}

	private static int lisLength(int[] arr) {
		int length = arr.length;
		int[] lis = new int[length];

		/* Initialize LIS values for all indexes */
		Arrays.fill(lis, 1);

		/* Compute optimized LIS values in bottom up manner */
		// if arr[i] > arr[j], then lis[i] = max(lis[i], lis[j] + 1)
		for (int i = 1; i < length; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j] && lis[j] + 1 > lis[i]) {
					lis[i] = lis[j] + 1;
				}
			}
		}

		/* Pick maximum of all LIS values */
		return Arrays.stream(lis).max().getAsInt();
	}

	private static int[] lis(int[] arr) {
		int length = arr.length;
		int[] lisLengths = new int[length];

		/* Initialize LIS values for all indexes */
		Arrays.fill(lisLengths, 1);

		/* Compute optimized LIS values in bottom up manner */
		// if arr[i] > arr[j], then lis[i] = max(lis[i], lis[j] + 1)
		for (int i = 1; i < length; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j]) {
					lisLengths[i] = Math.max(lisLengths[i], lisLengths[j] + 1);
				}
			}
		}

		/* Pick maximum of all LIS values */
		int lisLength = Arrays.stream(lisLengths).max().getAsInt();

		int[] lis = new int[lisLength];
		for (int i = length - 1; i >= 0; i--) {
			if (lisLengths[i] == lisLength) {
				lis[lisLength - 1] = arr[i];
				lisLength--;
			}
		}
		return lis;
	}

}
