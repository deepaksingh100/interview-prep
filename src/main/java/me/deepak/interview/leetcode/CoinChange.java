package me.deepak.interview.leetcode;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/coin-change/
 * 
 * https://www.geeksforgeeks.org/find-minimum-number-of-coins-that-make-a-
 * change/
 * 
 * https://www.youtube.com/watch?v=jgiZlGzXMBw
 * 
 */

public class CoinChange {

	public int coinChange(int[] coins, int amount) {
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

}
