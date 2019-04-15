package me.deepak.interview.dynamic_programming;

import java.util.Arrays;

public class CoinChange {

	private static int getWaysToChangeCoin(int[] coins, int amount) {
		int length = coins.length;
		int[][] table = new int[length + 1][amount + 1];
		for (int i = 0; i <= length; i++) {
			table[i][0] = 1;
		}
		for (int i = 1; i <= length; i++) {
			for (int j = 1; j <= amount; j++) {
				if (coins[i - 1] > j) {
					table[i][j] = table[i - 1][j];
				} else {
					table[i][j] = table[i - 1][j] + table[i][j - coins[i - 1]];
				}
			}
		}
		return table[length][amount];
	}

	private static int getNumberOfMinimumChangeCoins(int[] coins, int amount) {
		int[] minChangeCoins = new int[amount + 1];
		Arrays.fill(minChangeCoins, Integer.MAX_VALUE);
		minChangeCoins[0] = 0;
		for (int i = 0; i < coins.length; i++) {
			for (int j = 1; j <= amount; j++) {
				if (j >= coins[i]) {
					int subResult = minChangeCoins[j - coins[i]];
					if (subResult != Integer.MAX_VALUE && subResult + 1 < minChangeCoins[j]) {
						minChangeCoins[j] = subResult + 1;
					}
				}
			}
		}
		return minChangeCoins[amount] == Integer.MAX_VALUE ? -1 : minChangeCoins[amount];
	}

	private static int[] getMinimumChangeCoins(int[] coins, int amount) {
		int[] minChangeCoins = new int[amount + 1];
		int[] lastChosenCoinIndexes = new int[amount + 1];
		Arrays.fill(minChangeCoins, Integer.MAX_VALUE);
		Arrays.fill(lastChosenCoinIndexes, -1);
		minChangeCoins[0] = 0;
		for (int i = 0; i < coins.length; i++) {
			for (int j = 1; j <= amount; j++) {
				if (j >= coins[i]) {
					int subResult = minChangeCoins[j - coins[i]];
					if (subResult != Integer.MAX_VALUE && subResult + 1 < minChangeCoins[j]) {
						minChangeCoins[j] = subResult + 1;
						lastChosenCoinIndexes[j] = i;
					}
				}
			}
		}

		if (minChangeCoins[amount] == Integer.MAX_VALUE) {
			return new int[0];
		}
		int[] chosenCoins = new int[minChangeCoins[amount]];
		int i = 0;
		int index = lastChosenCoinIndexes.length - 1;
		while (index != 0) {
			int lastChosenCoinIndex = lastChosenCoinIndexes[index];
			chosenCoins[i++] = coins[lastChosenCoinIndex];
			index = index - coins[lastChosenCoinIndex];
		}
		return chosenCoins;
	}

}
