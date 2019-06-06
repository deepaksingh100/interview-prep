package me.deepak.interview.leetcode;

/*
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 * https://leetcode.com/articles/best-time-to-buy-and-sell-stock-ii/
*/
public class BestTimeToBuyAndSellStock2 {

	public int maxProfit(int[] a) {

		int i = 0;
		int maxProfit = 0;
		int n = a.length;
		int valley;
		int peak;

		while (i < n - 1) {
			while (i < n - 1 && a[i] >= a[i + 1]) {
				i++;
			}
			valley = a[i];
			while (i < n - 1 && a[i] <= a[i + 1]) {
				i++;
			}
			peak = a[i];
			maxProfit += peak - valley;
		}
		return maxProfit;

	}

}
