package me.deepak.interview.dynamic_programming;

import java.util.Arrays;

/*
 * https://qr.ae/TWnZOB
 * https://www.geeksforgeeks.org/maximum-profit-sale-wines/
*/
public class MaximumProfitFromSaleOfWines {

	public int maxProfit(int[] price) {
		int n = price.length;

		// Initialize memo
		int[][] memo = new int[n + 1][n + 1];
		Arrays.fill(memo, -1);

		return maxProfitMemoized(price, 0, n - 1, memo);
	}

	private int maxProfitRecursive(int[] price, int start, int end) {
		if (start > end) {
			return 0;
		}

		// (end - start + 1) is the number of unsold wines, year would be number of sold
		// wines + 1
		int year = price.length - (end - start + 1) + 1;

		return Math.max(year * price[start] + maxProfitRecursive(price, start + 1, end),
				year * price[end] + maxProfitRecursive(price, start, end - 1));
	}

	private int maxProfitMemoized(int[] price, int start, int end, int[][] memo) {

		if (start > end) {
			return 0;
		}

		// these two lines save the day
		if (memo[start][end] != -1) {
			return memo[start][end];
		}

		// (end - start + 1) is the number of unsold wines, year would be number of sold
		// wines + 1
		int year = price.length - (end - start);

		// If not calculated so far
		return memo[start][end] = Math.max(year * price[start] + maxProfitMemoized(price, start + 1, end, memo),
				year * price[end] + maxProfitMemoized(price, start, end - 1, memo));
	}

}
