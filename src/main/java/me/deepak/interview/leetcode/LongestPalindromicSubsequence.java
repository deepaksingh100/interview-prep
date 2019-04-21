package me.deepak.interview.leetcode;

/*
 * https://leetcode.com/problems/longest-palindromic-subsequence/
*/

public class LongestPalindromicSubsequence {

	public int longestPalindromeSubseq(String s) {
		return lpsLength(s.toCharArray());
	}

	private static int lpsLength(char[] sequence) {
		int length = sequence.length;
		int[][] table = new int[length][length];
		for (int i = 0; i < length; i++) {
			table[i][i] = 1;
		}
		for (int currentLength = 2; currentLength <= length; currentLength++) {
			for (int i = 0; i < length - currentLength + 1; i++) {
				int j = i + currentLength - 1;
				if (sequence[i] == sequence[j] && currentLength == 2) {
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

}
