package me.deepak.interview.geeksforgeeks;

import java.util.Arrays;

/*
 * https://www.geeksforgeeks.org/chocolate-distribution-problem/
*/
public class ChocolateDistributionProblem {

	private ChocolateDistributionProblem() {
	}

	// a[] represents sizes of packets. m is number of students. Returns
	// minimum difference between maximum and minimum values of distribution.
	public static int solve(int[] a, int m) {
		Arrays.sort(a);

		int minDiff = Integer.MAX_VALUE;
		int left = 0;
		int right = m - 1;

		while (right < a.length) {
			minDiff = Math.min(minDiff, a[right++] - a[left++]);
		}
		return minDiff;
	}

}
