package me.deepak.interview.dynamic_programming;

public class LongestCommonSubstring {

	public static int lcsLength(char[] sequence1, char[] sequence2) {
		int length1 = sequence1.length;
		int length2 = sequence2.length;
		int max = 0;
		int[][] table = new int[length1 + 1][length2 + 1];
		for (int i = 0; i <= length1; i++) {
			for (int j = 0; j <= length2; j++) {
				if (i == 0 || j == 0) {
					table[i][j] = 0;
				} else if (sequence1[i - 1] == sequence2[j - 1]) {
					table[i][j] = table[i - 1][j - 1] + 1;
					max = Math.max(max, table[i][j]);
				}
			}
		}
		return max;
	}
}
