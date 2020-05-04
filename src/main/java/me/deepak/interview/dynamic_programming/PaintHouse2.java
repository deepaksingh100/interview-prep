package me.deepak.interview.dynamic_programming;

/*
 * https://leetfree.com/problems/paint-house-ii.html
 * http://buttercola.blogspot.com/2015/09/leetcode-paint-house-ii.html
 * https://www.cnblogs.com/airwindow/p/4804011.html
*/
public class PaintHouse2 {

	public int minCostII(int[][] costs) {
		if (costs == null || costs.length == 0) {
			return 0;
		}

		int n = costs.length; // number of houses
		int k = costs[0].length; // number of colors

		int[][] minCost = new int[n][k];

		// base case
		for (int i = 0; i < k; i++) {
			minCost[0][i] = costs[0][i];
		}

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < k; j++) {
				minCost[i][j] = Integer.MAX_VALUE;
				for (int m = 0; m < k; m++) {
					if (m != j) {
						minCost[i][j] = Math.min(minCost[i][j], minCost[i - 1][m] + costs[i][j]);
					}
				}
			}
		}

		int min = Integer.MAX_VALUE;
		for (int i = 0; i < k; i++) {
			min = Math.min(min, minCost[n - 1][i]);
		}

		return min;
	}

	public int minCostIISpaceOptimized(int[][] costs) {
		if (costs == null || costs.length == 0) {
			return 0;
		}

		int n = costs.length;
		int k = costs[0].length;

		// dp[j] means the min cost for color j
		int[] dp1 = new int[k];
		int[] dp2 = new int[k];

		// Initialization
		for (int i = 0; i < k; i++) {
			dp1[i] = costs[0][i];
		}

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < k; j++) {
				dp2[j] = Integer.MAX_VALUE;
				for (int m = 0; m < k; m++) {
					if (m != j) {
						dp2[j] = Math.min(dp1[m] + costs[i][j], dp2[j]);
					}
				}
			}

			for (int j = 0; j < k; j++) {
				dp1[j] = dp2[j];
			}
		}

		// Final state
		int minCost = Integer.MAX_VALUE;
		for (int i = 0; i < k; i++) {
			minCost = Math.min(minCost, dp1[i]);
		}

		return minCost;
	}

	public int minCostIITimeOptimized(int[][] costs) {
		if (costs == null || costs.length == 0) {
			return 0;
		}

		int n = costs.length;
		int k = costs[0].length;

		// dp[j] means the min cost for color j
		int[] dp = new int[k];
		int min1 = 0;
		int min2 = 0;

		for (int i = 0; i < n; i++) {
			int oldMin1 = min1;
			int oldMin2 = min2;

			min1 = Integer.MAX_VALUE;
			min2 = Integer.MAX_VALUE;

			for (int j = 0; j < k; j++) {
				if (dp[j] != oldMin1 || oldMin1 == oldMin2) {
					dp[j] = oldMin1 + costs[i][j];
				} else {
					dp[j] = oldMin2 + costs[i][j];
				}

				if (min1 <= dp[j]) {
					min2 = Math.min(min2, dp[j]);
				} else {
					min2 = min1;
					min1 = dp[j];
				}
			}

		}

		return min1;
	}

}
