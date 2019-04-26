package me.deepak.interview.dynamic_programming;

/*
 * https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/
*/

public class Knapsack {

	private Knapsack() {
	}

	public static double knapsack01(int[] values, int[] weights, int capacity) {
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
					 * 
					 */
					table[i][j] = table[i - 1][j];
				} else {
					/*
					 * Return the maximum of two cases: (1) (i - 1)th item included (2) not included
					 * 
					 */
					table[i][j] = Math.max(values[i - 1] + table[i - 1][j - weights[i - 1]], table[i - 1][j]);
				}
			}
		}
		return table[length][capacity];
	}

}
