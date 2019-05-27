package me.deepak.interview.dynamic_programming;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MaximumSumIncreasingSubsequence {

	private MaximumSumIncreasingSubsequence() {
	}

	/*
	 * https://www.geeksforgeeks.org/maximum-sum-increasing-subsequence-dp-14/
	 */
	public static int msisLength(int[] arr) {
		int length = arr.length;
		int[] msi = new int[length];

		/* Initialize MSI values for all indexes */
		System.arraycopy(arr, 0, msi, 0, length);

		/* Compute optimized MSIS values in bottom up manner */
		for (int i = 1; i < length; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j]) {
					msi[i] = Math.max(msi[i], msi[j] + arr[i]);
				}
			}
		}

		/* Pick maximum of all MSIS values */
		return Arrays.stream(msi).max().getAsInt();
	}

	/*
	 * https://www.geeksforgeeks.org/printing-maximum-sum-increasing-subsequence/
	 */
	public static List<Integer> msis(int[] arr) {
		int length = arr.length;
		int[] msi = new int[length];

		/* Initialize MSIS values for all indexes */
		System.arraycopy(arr, 0, msi, 0, length);

		/* Compute optimized MSIS values in bottom up manner */
		for (int i = 1; i < length; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j]) {
					msi[i] = Math.max(msi[i], msi[j] + arr[i]);
				}
			}
		}

		/* Pick maximum of all MSIS values */
		int msiSum = Arrays.stream(msi).max().getAsInt();

		LinkedList<Integer> msis = new LinkedList<>();

		// loop on lisLengths
		for (int i = length - 1; i >= 0; i--) {

			if (msi[i] == msiSum) {
				msis.addFirst(arr[i]);
				msiSum -= arr[i];
			}
		}
		return msis;
	}
}
