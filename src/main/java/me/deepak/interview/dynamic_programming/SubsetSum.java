package me.deepak.interview.dynamic_programming;

import java.util.Arrays;
import java.util.List;

public class SubsetSum {

	private SubsetSum() {
	}

	/*
	 * https://www.geeksforgeeks.org/subset-sum-problem-dp-25/
	 */
	public static boolean isSubsetSum(int[] set, int sum) {
		int length = set.length;

		/*
		 * The value of table[i][j] will be true if there is a subset of set[0..i - 1]
		 * with sum equal to j
		 */
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

	/*
	 * https://www.geeksforgeeks.org/subset-sum-problem-dp-25/
	 */
	public static boolean isSubsetSumSpaceOptimized(int[] set, int sum) {

		// We need only previous row to fill next row, thus we can use 2 rows for this
		// purpose
		boolean[][] table = new boolean[2][sum + 1];

		// sum zero is always achievable
		for (int i = 0; i < 2; i++) {
			table[i][0] = true;
		}

		int currentRow = 0;
		for (int i = 1; i <= set.length; i++) {

			// set current row to 0 if i is EVEN and 1 i is ODD
			currentRow = i & 1; // odd even style
			for (int j = 1; j <= sum; j++) {

				// If current element is greater than sum j
				if (j < set[i - 1]) {

					// Exclude the last element, recur for n = n - 1.
					table[currentRow][j] = table[1 - currentRow][j];
				} else {
					table[currentRow][j] = table[1 - currentRow][j] // Exclude the last element, recur for n = n - 1.
							|| table[1 - currentRow][j - set[i - 1]] // Include the last element, recur for n = n - 1,
																		// sum = sum - set[n - 1]
					;
				}
			}
		}
		return table[currentRow][sum];
	}

	/*
	 * https://leetcode.com/problems/partition-equal-subset-sum/
	 * https://www.geeksforgeeks.org/partition-problem-dp-18/
	 */

	public static boolean isSameSumSubsetPartition(int[] set) {
		int sum = Arrays.stream(set).sum();

		// If sum is odd, can partition in equal sum subset
		if ((sum & 1) != 0) {
			return false;
		}

		// half the sum
		sum >>>= 1;

		// check if given set contains subset of calculated sum
		return isSubsetSum(set, sum);
	}

	/*
	 * https://www.geeksforgeeks.org/partition-a-set-into-two-subsets-such-that-the-
	 * difference-of-subset-sums-is-minimum/
	 */

	public static int getBalancedPartitionedDiff(int[] set) {
		int length = set.length;
		int sum = Arrays.stream(set).sum();

		/*
		 * The value of table[i][j] will be true if there is a subset of set[0..i - 1]
		 * with sum equal to j
		 */
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
							|| table[i - 1][j - set[i - 1]]// Include the last element, recur for n = n - 1, sum = sum -
															// set[n - 1]
					;
				}
			}
		}
		int diff = Integer.MAX_VALUE;
		for (int i = sum / 2; i >= 0; i--) {

			// finding just smaller possible sum than sum / 2
			if (table[length][i]) {

				// found just smaller possible sum = i => diff = (sum - i) - i => diff = sum - 2
				// * i
				diff = sum - 2 * i;
				break;
			}
		}
		return diff;
	}

	/*
	 * https://www.geeksforgeeks.org/partition-a-set-into-two-subsets-such-that-the-
	 * difference-of-subset-sums-is-minimum/
	 */

	public static int getBalancedPartitionedDiffSpaceOptimized(int[] set) {
		int length = set.length;
		int sum = Arrays.stream(set).sum();
		// We need only previous row to fill next row, thus we can use 2 rows for this
		// purpose
		boolean[][] table = new boolean[2][sum + 1];

		// sum zero is always achievable
		for (int i = 0; i < 2; i++) {
			table[i][0] = true;
		}

		int currentRow = 0;
		for (int i = 1; i <= length; i++) {

			// set current row to 0 if i is EVEN and 1 i is ODD
			currentRow = i & 1; // odd even style
			for (int j = 1; j <= sum; j++) {

				// If current element is greater than sum j
				if (j < set[i - 1]) {

					// Exclude the last element, recur for n = n - 1.
					table[currentRow][j] = table[1 - currentRow][j];
				} else {
					table[currentRow][j] = table[1 - currentRow][j] // Exclude the last element, recur for n = n - 1.
							|| table[1 - currentRow][j - set[i - 1]] // Include the last element, recur for n = n - 1,
																		// sum = sum - set[n - 1]
					;
				}
			}
		}
		int diff = Integer.MAX_VALUE;
		for (int i = sum / 2; i >= 0; i--) {

			// finding just smaller possible sum than sum / 2
			if (table[currentRow][i]) {

				// found just smaller possible sum = i => diff = (sum - i) - i => diff = sum - 2
				// * i
				diff = sum - 2 * i;
				break;
			}
		}
		return diff;
	}

	/*
	 * https://stackoverflow.com/questions/22891076/count-number-of-subsets-with-sum
	 * -equal-to-k
	 * 
	 * https://practice.geeksforgeeks.org/problems/perfect-sum-problem/0
	 */
	public static int countSubsets(int[] set, int sum) {
		int length = set.length;

		/*
		 * The value of table[i][j] will be true if there is a subset of set[0..i - 1]
		 * with sum equal to j
		 */
		int[][] table = new int[length + 1][sum + 1];

		// sum zero is always achievable
		for (int i = 0; i <= length; i++) {
			table[i][0] = 1;
		}
		for (int i = 1; i <= length; i++) {
			for (int j = 1; j <= sum; j++) {

				// If current element is greater than sum j
				if (j < set[i - 1]) {

					// Exclude the last element, recur for n = n - 1.
					table[i][j] = table[i - 1][j];
				} else {
					table[i][j] = table[i - 1][j] // Exclude the last element, recur for n = n - 1.
							+ table[i - 1][j - set[i - 1]]// Include the last element, recur for n = n - 1, sum = sum –
															// set[n - 1]
					;
				}
			}
		}
		return table[length][sum];
	}

	/*
	 * https://stackoverflow.com/questions/22891076/count-number-of-subsets-with-sum
	 * -equal-to-k
	 * 
	 * https://practice.geeksforgeeks.org/problems/perfect-sum-problem/0
	 */
	public static int countSubsetsSpaceOptimized(int[] set, int sum) {

		// We need only previous row to fill next row, thus we can use 2 rows for this
		// purpose
		int[][] table = new int[2][sum + 1];

		// sum zero is always achievable
		for (int i = 0; i < 2; i++) {
			table[i][0] = 1;
		}

		int currentRow = 0;
		for (int i = 1; i <= set.length; i++) {

			// set current row to 0 if i is EVEN and 1 i is ODD
			currentRow = i & 1; // odd even style
			for (int j = 1; j <= sum; j++) {

				// If current element is greater than sum j
				if (j < set[i - 1]) {

					// Exclude the last element, recur for n = n - 1.
					table[currentRow][j] = table[1 - currentRow][j];
				} else {
					table[currentRow][j] = table[1 - currentRow][j] // Exclude the last element, recur for n = n - 1.
							+ table[1 - currentRow][j - set[i - 1]] // Include the last element, recur for n = n - 1,
																	// sum = sum - set[n - 1]
					;
				}
			}
		}
		return table[currentRow][sum];
	}

	/*
	 * https://www.geeksforgeeks.org/perfect-sum-problem-print-subsets-given-sum/
	 */

	public static List<int[]> getSubsets(int[] set, int sum) {
		return null;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 3, 5, 5, 2, 1, 1, 6 };
		System.out.println(isSameSumSubsetPartition(arr));

		int[] arr1 = { 2, 3, 7, 8 };
		System.out.print(isSubsetSum(arr1, 11));

	}
}