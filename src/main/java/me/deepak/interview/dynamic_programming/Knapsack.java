package me.deepak.interview.dynamic_programming;

import java.util.ArrayList;
import java.util.List;

public class Knapsack {

	private Knapsack() {
	}

	/*
	 * https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/
	 */
	public static int knapsack01(int[] values, int[] weights, int capacity) {
		int length = values.length;
		int[][] table = new int[length + 1][capacity + 1];
		for (int i = 0; i <= length; i++) {
			for (int j = 0; j <= capacity; j++) {
				if (i == 0 || j == 0) {

					// If values[] is empty OR capacity is zero, answer is zero
					table[i][j] = 0;
				} else if (j < weights[i - 1]) {

					/*
					 * If capacity j is less than current weight weights[i - 1], We can't include
					 * this weight in our optimal solution
					 */
					table[i][j] = table[i - 1][j];
				} else {

					/*
					 * Return the maximum of two cases: (1) (i - 1)th item included (2) not included
					 */
					table[i][j] = Math.max(values[i - 1] + table[i - 1][j - weights[i - 1]], table[i - 1][j]);
				}
			}
		}
		return table[length][capacity];
	}

	/*
	 * https://www.geeksforgeeks.org/printing-items-01-knapsack/
	 */
	public static List<Integer> knapsack01Items(int[] values, int[] weights, int capacity) {
		int length = values.length;
		int[][] table = new int[length + 1][capacity + 1];
		for (int i = 0; i <= length; i++) {
			for (int j = 0; j <= capacity; j++) {
				if (i == 0 || j == 0) {

					// If values[] is empty OR capacity is zero, answer is zero
					table[i][j] = 0;
				} else if (j < weights[i - 1]) {

					/*
					 * If capacity j is less than current weight weights[i - 1], We can't include
					 * this weight in our optimal solution
					 */
					table[i][j] = table[i - 1][j];
				} else {

					/*
					 * Return the maximum of two cases: (1) (i - 1)th item included (2) not included
					 */
					table[i][j] = Math.max(values[i - 1] + table[i - 1][j - weights[i - 1]], table[i - 1][j]);
				}
			}
		}

		List<Integer> itemsInKnapsack = new ArrayList<>();
		int i = length;
		int j = capacity;
		while (i > 0 && j > 0) {

			/*
			 * either the result comes from the top (table[i - 1][j]) or from (values[i - 1]
			 * + table[i - 1][j - weights[i - 1]]) as in Knapsack table. If it comes from
			 * the latter one it means the item is included.
			 * 
			 * http://cse.unl.edu/~goddard/Courses/CSCE310J/Lectures/Lecture8-
			 * DynamicProgramming.pdf
			 */
			if (table[i][j] != table[i - 1][j]) {
				itemsInKnapsack.add(weights[i - 1]);
				j -= weights[i - 1];
			}
			i--;
		}
		return itemsInKnapsack;
	}

	/*
	 * https://www.geeksforgeeks.org/unbounded-knapsack-repetition-items-allowed/
	 */
	public static int knapsackUnbounded(int[] values, int[] weights, int capacity) {

		// table[i] is going to store maximum value with knapsack capacity i.
		int[] table = new int[capacity + 1];

		/*
		 * table[i] = max(table[i], table[i - weights[j]] + values[j] where j varies
		 * from 0 to n-1 such that: weights[j] <= i
		 */
		for (int i = 0; i <= capacity; i++) {
			for (int j = 0; j < weights.length; j++) {
				if (weights[j] <= i) {
					table[i] = Math.max(table[i], table[i - weights[j]] + values[j]);
				}
			}
		}
		return table[capacity];
	}

	// Driver code
	public static void main(String[] arg) {
		int[] values = { 92, 57, 49, 68, 60, 43, 67, 84, 87, 72 };
		int[] weights = { 23, 31, 29, 44, 53, 38, 63, 85, 89, 82 };
		int capacity = 165;

		System.out.println(knapsack01Items(values, weights, capacity));
	}

}
