package me.deepak.interview.dynamic_programming;

public class LongestPalindromicSubsequence {

	public static int lpsLength(char[] sequence) {
		/*char[] reverseSequence = new StringBuilder(new String(sequence)).reverse().toString().toCharArray();
		return LongestCommonSubsequence.lcsLength(sequence, reverseSequence);*/
		int length = sequence.length;
		int[][] table = new int[length][length];
		for (int i = 0; i < length; i++) {
			table[i][i] = 1;
		}
		for (int l = 2; l <= length; l++) {
			for (int i = 0; i < length - l + 1; i++) {
				int j = i + l - 1;
				if (sequence[i] == sequence[j] && l == 2) {
					table[i][j] = 2;
				} else if (sequence[i] == sequence[j]) {
					table[i][j] = table[i + 1][j - 1] + 2;
				} else {
					table[i][j] = Math.max(table[i][j - 1], table[i + 1][j]);
				}
			}
		}
		return table[0][length - 1];
	}

	public static int[] lps(char[] sequence) {
		char[] reverseSequence = new StringBuilder(new String(sequence)).reverse().toString().toCharArray();
		return LongestCommonSubsequence.lcs(sequence, reverseSequence);
	}

}
