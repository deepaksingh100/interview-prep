package me.deepak.interview.leetcode;

/*
 * https://leetcode.com/problems/longest-palindromic-substring/
*/

public class LongestPalindromicSubstring {

	public String longestPalindrome(String s) {
		if (s == null || s.trim().equals("")) {
			return "";
		}

		int length = s.length();

		// length of longest palindrome substring found
		int maxLength = 1;

		// table[i][j] = true means String s[i...j] is palindrome, else not
		boolean[][] table = new boolean[length][length];

		// All substrings of length 1 are palindromes
		for (int i = 0; i < length; i++) {
			table[i][i] = true;
		}

		// index where the longest palindrome starts
		int start = 0;

		// check for substring of length 2.
		for (int i = 0; i < length - 1; i++) {
			if (s.charAt(i) == s.charAt(i + 1)) {
				table[i][i + 1] = true;
				start = i;
				maxLength = 2;
			}
		}

		/*
		 * Build the table. Note that the lower diagonal values of table are useless and
		 * not filled in the process. check for every substring of every length (from 3
		 * to length).
		 */
		for (int l = 3; l <= length; l++) {
			for (int i = 0; i < length - l + 1; i++) {

				// end index of current substring is j. start index is i. length is l.
				int j = i + l - 1;

				// If s[i + 1...j - 1] is palindrome && chars at i and j are same
				if (table[i + 1][j - 1] && s.charAt(i) == s.charAt(j)) {

					// Mark that s[i...j] is palindrome
					table[i][j] = true;

					// If current length is greater than maxLength, update start index and maxLength
					if (l > maxLength) {
						start = i;
						maxLength = l;
					}
				}
			}
		}
		return s.substring(start, start + maxLength);
	}

}
