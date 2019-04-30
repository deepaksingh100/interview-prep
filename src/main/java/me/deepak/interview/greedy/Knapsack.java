package me.deepak.interview.greedy;

import java.util.Arrays;

/*
 * https://www.geeksforgeeks.org/fractional-knapsack-problem/
*/
public class Knapsack {

	private Knapsack() {
	}

	public static double knapsackFractional(int[] values, int[] weights, int capacity) {
		int length = values.length;
		Item[] items = new Item[length];
		for (int i = 0; i < length; i++) {
			items[i] = new Item(values[i], weights[i]);
		}

		// sort items in non-ascending order of cost
		Arrays.sort(items, (item1, item2) -> Double.compare(item2.cost, item1.cost));

		double totalValue = 0;
		for (Item item : items) {
			if (item.weight <= capacity) {

				// if current item's cost is less than or equals to remaining capacity,
				// add it's value to total value, subtract it's weight from remaining capacity.
				totalValue += item.value;
				capacity -= item.weight;
			} else {

				// if current item's cost is greater than remaining capacity, add possible
				// fraction to answer means add it's cost (per unit weight) multiplied by
				// remaining capacity to total value. Then break.
				totalValue += item.cost * capacity;
				break;
			}
		}
		return totalValue;
	}

	private static final class Item {
		private int value;
		private int weight;

		// per unit cost
		private double cost;

		private Item(int value, int weight) {
			this.value = value;
			this.weight = weight;
			this.cost = (double) value / weight;
		}
	}
}
