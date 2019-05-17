package me.deepak.interview.dynamic_programming;

public class LongestCommonSubsequence {

	private LongestCommonSubsequence() {
	}

	/*
	 * https://www.geeksforgeeks.org/longest-common-subsequence-dp-4/
	 */

	public static int lcsLength(char[] sequence1, char[] sequence2) {
		int length1 = sequence1.length;
		int length2 = sequence2.length;
		int[][] table = new int[length1 + 1][length2 + 1];
		for (int i = 0; i <= length1; i++) {
			for (int j = 0; j <= length2; j++) {
				if (i == 0 || j == 0) {

					// If any of the string is empty, answer is 0
					table[i][j] = 0;
				} else if (sequence1[i - 1] == sequence2[j - 1]) {

					// If sequence1[i - 1] == sequence2[j - 1], we add 1 to the answer and move 1
					// index backward in both string
					table[i][j] = 1 + table[i - 1][j - 1];
				} else {

					// If sequence1[i - 1] != sequence2[j - 1], answer will be max of (1) move 1
					// index backward in sequence1 (2) move 1 index backward in sequence2
					table[i][j] = Math.max(table[i - 1][j], table[i][j - 1]);
				}
			}
		}
		return table[length1][length2];
	}

	/*
	 * https://www.geeksforgeeks.org/space-optimized-solution-lcs/
	 */

	public static int lcsLengthSpaceOptimized(char[] sequence1, char[] sequence2) {
		int length1 = sequence1.length;
		int length2 = sequence2.length;

		// We need only previous row to fill next row, thus we can use 2 rows for this
		// purpose
		int[][] table = new int[2][length2 + 1];
		int currentRow = 0;
		for (int i = 0; i <= length1; i++) {

			// set current row to 0 if i is EVEN and 1 if i is ODD
			currentRow = i & 1; // odd even style
			for (int j = 0; j <= length2; j++) {
				if (i == 0 || j == 0) {

					// If any of the string is empty, answer is 0
					table[currentRow][j] = 0;
				} else if (sequence1[i - 1] == sequence2[j - 1]) {

					// If sequence1[i - 1] == sequence2[j - 1], we add 1 to the answer and move 1
					// index backward in both string
					table[currentRow][j] = 1 + table[1 - currentRow][j - 1];
				} else {

					// If sequence1[i - 1] != sequence2[j - 1], answer will be max of (1) move 1
					// index backward in sequence1 (2) move 1 index backward in sequence2
					table[currentRow][j] = Math.max(table[1 - currentRow][j], table[currentRow][j - 1]);
				}
			}
		}
		return table[currentRow][length2];
	}

	/*
	 * https://www.geeksforgeeks.org/printing-longest-common-subsequence/
	 */

	public static int[] lcs(char[] sequence1, char[] sequence2) {
		int length1 = sequence1.length;
		int length2 = sequence2.length;
		int[][] table = new int[length1 + 1][length2 + 1];
		for (int i = 0; i <= length1; i++) {
			for (int j = 0; j <= length2; j++) {
				if (i == 0 || j == 0) {

					// If any of the string is empty, answer is 0
					table[i][j] = 0;
				} else if (sequence1[i - 1] == sequence2[j - 1]) {

					// If sequence1[i - 1] == sequence2[j - 1], we add 1 to the answer and move 1
					// index backward in both string
					table[i][j] = 1 + table[i - 1][j - 1];
				} else {

					// If sequence1[i - 1] != sequence2[j - 1], answer will be max of (1) move 1
					// index backward in sequence1 (2) move 1 index backward in sequence2
					table[i][j] = Math.max(table[i - 1][j], table[i][j - 1]);
				}
			}
		}
		int lcsLength = table[length1][length2];
		int[] lcs = new int[lcsLength];
		int i = length1;
		int j = length2;
		while (i > 0 && j > 0) {
			if (sequence1[i - 1] == sequence2[j - 1]) {

				/*
				 * If sequence1[i - 1] == sequence2[j - 1], we add current char (sequence1[i -
				 * 1]) to answer and move 1 index backward in both string
				 * 
				 */
				lcs[lcsLength - 1] = sequence1[i - 1];
				lcsLength--;
				i--;
				j--;
			} else {

				/*
				 * max(table[i - 1][j], table[i][j - 1]) was filled while filling the table, So
				 * if table[i - 1][j] > table[i][j - 1] then move 1 index backward in sequence1
				 * else move 1 index backward in sequence2
				 * 
				 */
				if (table[i - 1][j] > table[i][j - 1]) {
					i--;
				} else {
					j--;
				}
			}
		}
		return lcs;
	}

}
