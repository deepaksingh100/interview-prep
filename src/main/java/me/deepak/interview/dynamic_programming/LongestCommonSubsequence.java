package me.deepak.interview.dynamic_programming;

public class LongestCommonSubsequence {

	public static int lcsLength(char[] sequence1, char[] sequence2) {
		int length1 = sequence1.length;
		int length2 = sequence2.length;
		int[][] table = new int[2][length2 + 1];
		int currentRow = 0;
		for (int i = 0; i <= length1; i++) {
			currentRow = i & 1; // odd even style
			for (int j = 0; j <= length2; j++) {
				if (i == 0 || j == 0) {
					table[currentRow][j] = 0;
				} else if (sequence1[i - 1] == sequence2[j - 1]) {
					table[currentRow][j] = 1 + table[1 - currentRow][j - 1];
				} else {
					table[currentRow][j] = Math.max(table[1 - currentRow][j], table[currentRow][j - 1]);
				}
			}
		}
		return table[currentRow][length2];
	}

	public static int[] lcs(char[] sequence1, char[] sequence2) {
		int length1 = sequence1.length;
		int length2 = sequence2.length;
		int[][] table = new int[length1 + 1][length2 + 1];
		for (int i = 0; i <= length1; i++) {
			for (int j = 0; j <= length2; j++) {
				if (i == 0 || j == 0) {
					table[i][j] = 0;
				} else if (sequence1[i - 1] == sequence2[j - 1]) {
					table[i][j] = 1 + table[i - 1][j - 1];
				} else {
					table[i][j] = Math.max(table[i - 1][j], table[i][j - 1]);
				}
			}
		}
		int lcsLength = table[length1][length2];
		int[] lcs = new int[lcsLength];
		while (length1 > 0 && length2 > 0) {
			if (sequence1[length1 - 1] == sequence2[length2 - 1]) {
				lcs[lcsLength - 1] = sequence1[length1 - 1];
				length1--;
				length2--;
				lcsLength--;
			} else {
				if (table[length1 - 1][length2] > table[length1][length2 - 1]) {
					length1--;
				} else {
					length2--;
				}
			}
		}
		return lcs;
	}

}
