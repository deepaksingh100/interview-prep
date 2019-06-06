package me.deepak.interview.leetcode;

/*
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * https://leetcode.com/articles/best-time-to-buy-and-sell-stock/
 * https://www.geeksforgeeks.org/maximum-difference-between-two-elements/
*/
public class BestTimeToBuyAndSellStock {

	public int maxProfit(int[] a) {

		if (a == null || a.length < 2) {
			return 0;
		}

		int maxDiff = a[1] - a[0];
		int minElement = a[0];

		for (int i = 1; i < a.length; i++) {
			maxDiff = Math.max(maxDiff, a[i] - minElement);
			minElement = Math.min(minElement, a[i]);
		}

		return maxDiff < 0 ? 0 : maxDiff;

	}

}
