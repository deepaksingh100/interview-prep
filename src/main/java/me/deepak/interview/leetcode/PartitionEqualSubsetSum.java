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
		boolean[][] table = new boolean[set.length + 1][sum + 1];
		for (int i = 0; i <= set.length; i++) {
			table[i][0] = true;
		}
		for (int i = 1; i <= set.length; i++) {
			for (int j = 1; j <= sum; j++) {
				if (j < set[i - 1]) {
					table[i][j] = table[i - 1][j];
				} else {
					table[i][j] = table[i - 1][j] || table[i - 1][j - set[i - 1]];
				}
				if (table[i][sum]) {
					return true;
				}
			}
		}
		return table[set.length][sum];
	}

}
