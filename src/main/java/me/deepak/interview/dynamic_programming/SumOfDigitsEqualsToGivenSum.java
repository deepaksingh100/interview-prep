package me.deepak.interview.dynamic_programming;

import java.util.Arrays;

/*
 * https://www.geeksforgeeks.org/count-of-n-digit-numbers-whose-sum-of-digits-equals-to-given-sum/
 * https://www.quora.com/Count-all-n-digit-numbers-whose-sum-of-digits-equals-to-given-sum-How-can-we-solve-this-problem-How-do-we-start-to-apply-DP-for-problems-like-this
*/
public class SumOfDigitsEqualsToGivenSum {

	private SumOfDigitsEqualsToGivenSum() {
	}

	private static int[][] memo;

	public static void init(int n, int sum) {
		memo = new int[n + 1][sum + 1];
		Arrays.fill(memo, -1);
	}

	// wrapper function
	public static int getCount(int n, int sum) {

		// subtracts numbers starting with 0
		return getCountMemoized(n, sum) - getCountMemoized(n - 1, sum);
	}

	private static int getCountRecursive(int n, int sum) {

		// eliminate invalid cases
		if (sum < 0) {
			return 0;
		}

		// base case
		if (n == 0) {
			return sum == 0 ? 1 : 0;
		}
		int ans = 0;

		// recurrence formula
		for (int k = 0; k <= 9; k++) {
			ans += getCountRecursive(n - 1, sum - k);
		}
		return ans;
	}

	private static int getCountMemoized(int n, int sum) {

		// eliminate invalid cases
		if (sum < 0) {
			return 0;
		}

		// base case
		if (n == 0) {
			return sum == 0 ? 1 : 0;
		}

		if (memo[n][sum] != -1) {
			return memo[n][sum];
		}

		int ans = 0;

		// recurrence formula
		for (int k = 0; k <= 9; k++) {
			ans += getCountMemoized(n - 1, sum - k);
		}
		memo[n][sum] = ans;
		return ans;
	}

}
