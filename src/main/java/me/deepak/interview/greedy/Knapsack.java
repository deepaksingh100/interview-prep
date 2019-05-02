package me.deepak.interview.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * https://www.geeksforgeeks.org/fractional-knapsack-problem/
*/
public class Knapsack {

	private Knapsack() {
	}

	/**
	 * Returns maximum value from given values, weights & capacity
	 */
	public static double knapsackFractional(int[] values, int[] weights, int capacity) {
		int length = values.length;
		Item[] items = new Item[length];
		for (int i = 0; i < length; i++) {
			items[i] = new Item(i + 1, values[i], weights[i]);
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

	/**
	 * Returns items in sequence which yields maximum value from given values,
	 * weights & capacity
	 */
	public static List<Item> knapsackFractionalSolution(int[] values, int[] weights, int capacity) {
		int length = values.length;
		Item[] items = new Item[length];
		for (int i = 0; i < length; i++) {
			items[i] = new Item(i + 1, values[i], weights[i]);
		}

		// sort items in non-ascending order of cost
		Arrays.sort(items, (item1, item2) -> Double.compare(item2.cost, item1.cost));

		// Holds optimal sequence, which gains optimal solution
		List<Item> sequence = new ArrayList<>();

		for (Item item : items) {
			if (item.weight <= capacity) {

				// if current item's cost is less than or equals to remaining capacity,
				// add this item to sequence, subtract it's weight from remaining capacity.
				capacity -= item.weight;
				sequence.add(item);
			} else {

				// if current item's cost is greater than remaining capacity, set possible
				// fraction to item's value means set it's cost (per unit weight) multiplied by
				// remaining capacity to item's value. Then break.
				// update item value to value which is possible in knapsack & weight as well
				item.value += item.cost * capacity;
				item.weight -= capacity;
				sequence.add(item);
				break;
			}
		}
		return sequence;
	}

	static final class Item {
		int id;
		int value;
		int weight;

		// per unit cost
		double cost;

		private Item(int id, int value, int weight) {
			this.id = id;
			this.value = value;
			this.weight = weight;
			this.cost = (double) value / weight;
		}
	}
}
