package me.deepak.interview.dynamic_programming;

import java.util.Arrays;

public class Knapsack {

	private static double knapsack01(int[] values, int[] weights, int capacity) {
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

	// This is greedy

	private static double knapsackFractional(int[] values, int[] weights, int capacity) {
		Item[] items = new Item[values.length];
		for (int i = 0; i < values.length; i++) {
			items[i] = new Item(values[i], weights[i]);
		}
		Arrays.sort(items, (item1, item2) -> Double.compare(item2.cost, item1.cost));
		double totalValue = 0;
		for (Item item : items) {
			if (item.weight <= capacity) {
				totalValue += item.value;
				capacity -= item.weight;
			} else {
				totalValue += (double) item.value * capacity / item.weight;
				break;
			}
		}
		return totalValue;
	}

	static class Item {
		int value;
		int weight;
		double cost;

		public Item(int value, int weight) {
			this.value = value;
			this.weight = weight;
			this.cost = (double) value / weight;
		}
	}

}
