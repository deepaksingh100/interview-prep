package me.deepak.interview.dynamic_programming;

import java.util.Arrays;

public class SubsetSum {

	public boolean isSubsetSum(int[] set, int sum) {
		boolean[][] table = new boolean[set.length + 1][sum + 1];
		for (int i = 0; i <= set.length; i++) {
			table[i][0] = true;
		}
		for (int row = 1; row <= set.length; row++) {
			for (int column = 1; column <= sum; column++) {
				if (column < set[row - 1]) {
					table[row][column] = table[row - 1][column];
				} else {
					table[row][column] = table[row - 1][column] || table[row - 1][column - set[row - 1]];
				}
			}
		}
		return table[set.length][sum];
	}

	public boolean isSameSumSubsetPartition(int[] set) {
		int sum = Arrays.stream(set).sum();
		if ((sum & 1) != 0) {
			return false;
		}
		sum >>>= 1;
		return isSubsetSum(set, sum);
	}

	public int getBalancedPartitionedDiff(int[] set) {
		int sum = Arrays.stream(set).sum();
		boolean[][] table = new boolean[set.length + 1][sum + 1];
		for (int i = 0; i <= set.length; i++) {
			table[i][0] = true;
		}
		for (int row = 1; row <= set.length; row++) {
			for (int column = 1; column <= sum; column++) {
				if (column < set[row - 1]) {
					table[row][column] = table[row - 1][column];
				} else {
					table[row][column] = table[row - 1][column] || table[row - 1][column - set[row - 1]];
				}
			}
		}
		int diff = Integer.MAX_VALUE;
		for (int i = sum / 2; i >= 0; i--) {
			if (table[set.length][i]) { // finding just small possible sum of sum/2
				diff = sum - 2 * i; // found just small possible sum = i => diff = (sum - i) - i => diff = sum - 2 *
									// i
				break;
			}
		}
		return diff;
	}

	public static void main(String args[]) {
		SubsetSum subsetSum = new SubsetSum();
		int arr[] = { 1, 3, 5, 5, 2, 1, 1, 6 };
		System.out.println(subsetSum.isSameSumSubsetPartition(arr));

		int arr1[] = { 2, 3, 7, 8 };
		System.out.print(subsetSum.isSubsetSum(arr1, 11));

	}
}