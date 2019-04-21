package me.deepak.interview.leetcode;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/coin-change/
*/

public class CoinChange {

	public int coinChange(int[] coins, int amount) {
		int[] minChangeCoins = new int[amount + 1];
		Arrays.fill(minChangeCoins, Integer.MAX_VALUE);
		minChangeCoins[0] = 0;
		for (int i = 0; i < coins.length; i++) {
			for (int j = 1; j <= amount; j++) {
				if (j >= coins[i]) {
					int subResult = minChangeCoins[j - coins[i]];
					if (subResult != Integer.MAX_VALUE && subResult + 1 < minChangeCoins[j])
						minChangeCoins[j] = subResult + 1;
				}
			}
		}
		return minChangeCoins[amount] == Integer.MAX_VALUE ? -1 : minChangeCoins[amount];
	}

}
