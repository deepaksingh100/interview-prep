package me.deepak.interview.dynamic_programming;

/*
 * https://www.hackerearth.com/practice/algorithms/dynamic-programming/introduction-to-dynamic-programming-1/practice-problems/algorithm/the-colorful-street-1/
 * https://www.quora.com/How-do-I-solve-the-colorful-street-problem-using-top-down-dynamic-programming
 * https://www.programcreek.com/2014/05/leetcode-paint-house-java/
*/
public class ColorFulStreet {

	private ColorFulStreet() {
	}

	public static int colorStreet(int[] pink, int[] orange, int[] yellow) {
		int n = pink.length;
		int[][] table = new int[3][n];
		table[0][0] = pink[0];
		table[1][0] = orange[0];
		table[2][0] = yellow[0];
		for (int i = 1; i < n; i++) {

			// choosing pink
			table[0][i] = Math.min(table[1][i - 1], table[2][i - 1]) + pink[i];

			// choosing orange
			table[1][i] = Math.min(table[0][i - 1], table[2][i - 1]) + orange[i];

			// choosing yellow
			table[2][i] = Math.min(table[0][i - 1], table[1][i - 1]) + yellow[i];
		}

		// returning final minimum value
		return Math.min(table[0][n - 1], Math.min(table[1][n - 1], table[2][n - 1]));
	}

}
