package me.deepak.interview.leetcode;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/partition-equal-subset-sum/
*/
public class PartitionEqualSubsetSum {

	public boolean canPartition(int[] set) {
		int sum = Arrays.stream(set).sum();
		if ((sum & 1) != 0) {
			return false;
		}
		sum >>>= 1;
		return isSubsetSum(set, sum);
	}

	private static boolean isSubsetSum(int[] set, int sum) {
		int length = set.length;
		boolean[][] table = new boolean[length + 1][sum + 1];

		// sum zero is always achievable
		for (int i = 0; i <= length; i++) {
			table[i][0] = true;
		}
		for (int i = 1; i <= length; i++) {
			for (int j = 1; j <= sum; j++) {

				// If current element is greater than sum j
				if (j < set[i - 1]) {

					// Exclude the last element, recur for n = n - 1.
					table[i][j] = table[i - 1][j];
				} else {
					table[i][j] = table[i - 1][j] // Exclude the last element, recur for n = n - 1.
							|| table[i - 1][j - set[i - 1]]// Include the last element, recur for n = n - 1, sum = sum –
															// set[n - 1]
					;
				}
			}
		}
		return table[length][sum];
	}

}
