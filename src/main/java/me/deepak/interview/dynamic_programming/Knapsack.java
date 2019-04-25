package me.deepak.interview.dynamic_programming;

public class Knapsack {

	private Knapsack() {
	}

	public static double knapsack01(int[] values, int[] weights, int capacity) {
		int[][] table = new int[values.length + 1][capacity + 1];
		for (int row = 0; row <= values.length; row++) {
			for (int column = 0; column <= capacity; column++) {
				if (row == 0 || column == 0) {
					table[row][column] = 0;
				} else if (column < weights[row - 1]) {
					table[row][column] = table[row - 1][column];
				} else {
					table[row][column] = Math.max(table[row - 1][column],
							values[row - 1] + table[row - 1][column - weights[row - 1]]);
				}
			}
		}
		return table[values.length][capacity];
	}

}
