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

		// Strings of length 1 are palindrome of length 1
		for (int i = 0; i < length; i++) {
			table[i][i] = 1;
		}

		/*
		 * Build the table. Note that the lower diagonal values of table are useless and
		 * not filled in the process. check for every substring of every length (from 2
		 * to length).
		 */
		for (int l = 2; l <= length; l++) {
			for (int i = 0; i < length - l + 1; i++) {

				// end index of current substring is j. start index is i. length is l.
				int j = i + l - 1;

				if (sequence[i] == sequence[j] && l == 2) {
					// palindrome with length 2
					table[i][j] = 2;
				} else if (sequence[i] == sequence[j]) {
					// move both end pointers by one
					table[i][j] = table[i + 1][j - 1] + 2;
				} else {
					// max(move left end pointer by one, move right end pointer by one)
					table[i][j] = Math.max(table[i][j - 1], table[i + 1][j]);
				}
			}
		}
		// table [i][j] stored lps of sequence[i...j]
		return table[0][length - 1];
	}

}
