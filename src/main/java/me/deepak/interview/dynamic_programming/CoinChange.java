package me.deepak.interview.dynamic_programming;

import java.util.Arrays;

public class CoinChange {

	private CoinChange() {
	}

	public static int getWaysToChangeCoin(int[] coins, int amount) {
		int length = coins.length;

		// Matrix with rows are representing coins & columns are representing amounts
		int[][] table = new int[length + 1][amount + 1];

		// only one way to achieve amount 0 regardless of given coins
		for (int i = 0; i <= length; i++) {
			table[i][0] = 1;
		}

		for (int i = 1; i <= length; i++) {
			for (int j = 1; j <= amount; j++) {

				if (coins[i - 1] > j) {
					/*
					 * Not possible to achieve amount j with coins[i - 1], so number of ways would
					 * not change
					 */
					table[i][j] = table[i - 1][j];
				} else {
					/*
					 * sum of ways to achieve amount j with coins[i - 1] & ways to achieve
					 * difference of amount j & coins[j - 1](j - coins[i - 1]) with coins[i - 1]
					 * 
					 * pichhle wale coin se kitne tarike se j amount bn rhi thi + is coin (coins[i -
					 * 1]) se kitne tarike se rest (j - coins[i - 1]) amount bn rhi h
					 */
					table[i][j] = table[i - 1][j] + table[i][j - coins[i - 1]];
				}
			}
		}
		return table[length][amount];
	}

	/*
	 * https://leetcode.com/problems/coin-change/
	 * 
	 * https://www.geeksforgeeks.org/find-minimum-number-of-coins-that-make-a-
	 * change/
	 * 
	 * https://www.youtube.com/watch?v=jgiZlGzXMBw
	 * 
	 */

	public static int getNumberOfMinimumChangeCoins(int[] coins, int amount) {
		/*
		 * Minimum change coins for that index
		 */
		int[] minChangeCoins = new int[amount + 1];
		Arrays.fill(minChangeCoins, Integer.MAX_VALUE);

		/*
		 * The answer to making change with minimum coins for 0 will always be 0 coins
		 * no matter what the coins we are given are
		 */
		minChangeCoins[0] = 0;

		// Solve every subproblem from 1 to amount
		for (int i = 1; i <= amount; i++) {
			// For each coin we are given
			for (int j = 0; j < coins.length; j++) {
				// If it is less than or equal to the sub problem amount
				if (coins[j] <= i) {
					// Try it. See if it gives us a more optimal solution
					minChangeCoins[i] = Math.min(minChangeCoins[i], minChangeCoins[i - coins[j]] + 1);
				}
			}
		}
		return minChangeCoins[amount] == Integer.MAX_VALUE ? -1 : minChangeCoins[amount];
	}

	public static int[] getMinimumChangeCoins(int[] coins, int amount) {

		/*
		 * Minimum change coins for that index (amount)
		 */
		int[] minChangeCoins = new int[amount + 1];

		/*
		 * Last chosen coin index to achieve that index (amount)
		 */
		int[] lastChosenCoinIndexes = new int[amount + 1];

		Arrays.fill(minChangeCoins, Integer.MAX_VALUE);
		Arrays.fill(lastChosenCoinIndexes, -1);

		/*
		 * The answer to making change with minimum coins for 0 will always be 0 coins
		 * no matter what the coins we are given are
		 */
		minChangeCoins[0] = 0;

		// Solve every subproblem from 1 to amount
		for (int i = 1; i <= amount; i++) {
			// For each coin we are given
			for (int j = 0; j < coins.length; j++) {
				// If it is less than or equal to the sub problem amount
				if (coins[j] <= i) {
					// Try it. See if it gives us a more optimal solution
					int subResult = minChangeCoins[i - coins[j]];
					if (subResult != Integer.MAX_VALUE && subResult + 1 < minChangeCoins[i]) {
						minChangeCoins[i] = subResult + 1;
						lastChosenCoinIndexes[i] = j;
					}
				}
			}
		}

		// If amount can't be achieved, return empty array
		if (minChangeCoins[amount] == Integer.MAX_VALUE) {
			return new int[0];
		}

		// Array to hold chosen coins to achieve given amount
		int[] chosenCoins = new int[minChangeCoins[amount]];
		int i = 0;
		int index = lastChosenCoinIndexes.length - 1;
		while (index != 0) {
			int lastChosenCoinIndex = lastChosenCoinIndexes[index];
			// put chosen coin to answer array
			chosenCoins[i++] = coins[lastChosenCoinIndex];
			// go to next amount which helped us achieve this amount
			index -= coins[lastChosenCoinIndex];
		}
		return chosenCoins;
	}

}
