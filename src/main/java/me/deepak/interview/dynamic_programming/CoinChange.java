package me.deepak.interview.dynamic_programming;

import java.util.Arrays;

public class CoinChange {

	private CoinChange() {
	}

	/*
	 * https://www.geeksforgeeks.org/coin-change-dp-7/
	 * https://youtu.be/DJ4a7cmjZY0
	 */
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
					 * Current coin's value is greater than amount j. So we can't include that coin
					 * to our answer. Answer would be same as for previous coin & same amount.
					 */
					table[i][j] = table[i - 1][j];
				} else {

					/*
					 * Either we include current coin OR not. If we include current coin, then
					 * number of coins would be same as we have infinite supply of that denomination
					 * & sum to achieve would reduced by coin's value. If we does not include
					 * current coin, then number of coins would reduced by 1 & sum remains same.
					 */
					table[i][j] = table[i - 1][j] // does not include current coin
							+ table[i][j - coins[i - 1]] // include current coin
					;
				}
			}
		}
		return table[length][amount];
	}

	/*
	 * https://leetcode.com/problems/coin-change/
	 * https://www.geeksforgeeks.org/find-minimum-number-of-coins-that-make-a-
	 * change/
	 * 
	 * https://www.youtube.com/watch?v=jgiZlGzXMBw
	 * 
	 */
	public static int getNumberOfMinimumChangeCoins(int[] coins, int amount) {

		// Minimum change coins for that index
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

					int subResult = minChangeCoins[i - coins[j]];
					if (subResult != Integer.MAX_VALUE) {
						// Either we include current coin OR not.
						minChangeCoins[i] = Math.min(minChangeCoins[i] // does not include current coin
								, subResult + 1) // include current coin
						;
					}
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
		 * Last chosen coin's index to achieve that index (amount)
		 */
		int[] lastChosenCoins = new int[amount + 1];

		Arrays.fill(minChangeCoins, Integer.MAX_VALUE);
		Arrays.fill(lastChosenCoins, -1);

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

					// Either we include current coin OR not.
					int subResult = minChangeCoins[i - coins[j]];
					if (subResult != Integer.MAX_VALUE && subResult + 1 < minChangeCoins[i]) {
						minChangeCoins[i] = subResult + 1;
						lastChosenCoins[i] = coins[j];
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
		int remainingAmount = amount;
		while (remainingAmount != 0) {
			int lastChosenCoin = lastChosenCoins[remainingAmount];

			// put chosen coin to answer array
			chosenCoins[i++] = lastChosenCoin;

			// go to next amount which helped us achieve this amount
			remainingAmount -= lastChosenCoin;
		}
		return chosenCoins;
	}

}
