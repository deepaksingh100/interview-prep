package me.deepak.interview.dynamic_programming;

import java.util.Arrays;

/*
 * https://www.geeksforgeeks.org/longest-common-substring-dp-29/
 * https://www.geeksforgeeks.org/print-longest-common-substring/
*/
public class LongestCommonSubstring {

	private LongestCommonSubstring() {
	}

	public static int lcsLength(char[] sequence1, char[] sequence2) {
		int length1 = sequence1.length;
		int length2 = sequence2.length;
		int result = 0;
		int[][] table = new int[length1 + 1][length2 + 1];
		for (int i = 0; i <= length1; i++) {
			for (int j = 0; j <= length2; j++) {
				if (i == 0 || j == 0) {

					// If any of the string is empty, answer is 0
					table[i][j] = 0;
				} else if (sequence1[i - 1] == sequence2[j - 1]) {

					/*
					 * If sequence1[i - 1] == sequence2[j - 1], we add 1 to the answer and move 1
					 * index backward in both string. Select max(previous_max, table[i][j])
					 */
					table[i][j] = 1 + table[i - 1][j - 1];
					result = Math.max(result, table[i][j]);
				}
			}
		}
		return result;
	}

	public static int lcsLengthSpaceOptimized(char[] sequence1, char[] sequence2) {
		int length1 = sequence1.length;
		int length2 = sequence2.length;
		int result = 0;

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

					/*
					 * If sequence1[i - 1] == sequence2[j - 1], we add 1 to the answer and move 1
					 * index backward in both string. Select max(previous_max, table[i][j])
					 */
					table[currentRow][j] = 1 + table[1 - currentRow][j - 1];
					result = Math.max(result, table[currentRow][j]);
				} else {

					// This code block is very important (must) if we are reusing rows (In Space
					// Optimized Solution)
					table[currentRow][j] = 0;
				}
			}
		}
		return result;
	}

	public static char[] lcs(char[] sequence1, char[] sequence2) {
		int length1 = sequence1.length;
		int length2 = sequence2.length;
		int result = 0;
		int row = 0;
		int column = 0;
		int[][] table = new int[length1 + 1][length2 + 1];
		for (int i = 0; i <= length1; i++) {
			for (int j = 0; j <= length2; j++) {
				if (i == 0 || j == 0) {

					// If any of the string is empty, answer is 0
					table[i][j] = 0;
				} else if (sequence1[i - 1] == sequence2[j - 1]) {

					/*
					 * If sequence1[i - 1] == sequence2[j - 1], we add 1 to the answer and move 1
					 * index backward in both string. Select max(previous_max, table[i][j])
					 */
					table[i][j] = 1 + table[i - 1][j - 1];
					if (table[i][j] > result) {
						result = table[i][j];
						row = i;
						column = j;
					}
				}
			}
		}
		char[] lcs = new char[result];

		/*
		 * traverse up diagonally from the (row, column) cell until table[row][col] != 0
		 */
		while (table[row][column] != 0) {
			lcs[--result] = sequence1[row - 1]; // or sequence2[column - 1]

			// move diagonally up to previous cell
			row--;
			column--;
		}
		return lcs;
	}

	public static char[] lcsSpaceOptimized(char[] sequence1, char[] sequence2) {
		int length1 = sequence1.length;
		int length2 = sequence2.length;
		int result = 0;

		// Variable to store ending point of
		// longest common subString in sequence1.
		int end = 0;

		// We need only previous row to fill next row, thus we can use 2 rows for this
		// purpose
		int[][] table = new int[2][length2 + 1];
		int currentRow = 0;
		for (int i = 0; i <= length1; i++) {

			// set current row to 0 if i is EVEN and 1 if i is ODD
			currentRow = i & 1; // odd even style
			for (int j = 0; j <= length2; j++) {
				if (i == 0 || j == 0) {

					// if any of the string is empty, answer is 0
					table[currentRow][j] = 0;
				} else if (sequence1[i - 1] == sequence2[j - 1]) {

					/*
					 * If sequence1[i - 1] == sequence2[j - 1], we add 1 to the answer and move 1
					 * index backward in both string. Select max(previous_max, table[i][j]) and
					 * update end
					 */
					table[currentRow][j] = 1 + table[1 - currentRow][j - 1];
					if (table[currentRow][j] > result) {
						result = table[currentRow][j];
						end = i;
					}
				} else {

					// This code block is very important (must) if we are reusing rows (In Space
					// Optimized Solution)
					table[currentRow][j] = 0;
				}
			}
		}
		return Arrays.copyOfRange(sequence1, end - result, end);

	}

	public static void main(String[] args) {
		char[] sequence1 = "LRBBMQBHCDARZOWKKYHIDDQSCDXRJMOWFRXSJYBLDBEFSARCBYNECDYGGXXPKLORELLNMPAPQFWKHOPKMCO"
				.toCharArray();
		char[] sequence2 = "QHNWNKUEWHSQMGBBUQCLJJIVSWMDKQTBXIXMVTRRBLJPTNSNFWZQFJMAFADRRWSOFSBCNUVQHFFBSAQXWPQCAC"
				.toCharArray();
		System.out.println(lcsSpaceOptimized(sequence1, sequence2));
	}
}
