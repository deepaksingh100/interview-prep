package me.deepak.interview.greedy;

import java.util.Arrays;

public class Knapsack {

	private Knapsack() {
	}

	public static double knapsackFractional(int[] values, int[] weights, int capacity) {
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
