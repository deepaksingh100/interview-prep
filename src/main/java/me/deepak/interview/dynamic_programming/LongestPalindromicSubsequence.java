package me.deepak.interview.dynamic_programming;

/*
 * https://www.geeksforgeeks.org/longest-palindromic-subsequence-dp-12/
 * https://www.geeksforgeeks.org/print-longest-palindromic-subsequence/
*/
public class LongestPalindromicSubsequence {

	private LongestPalindromicSubsequence() {
	}

	public static int lpsLengthUsingLCS(char[] sequence) {

		// Reverse the given sequence and store the reverse in another array
		char[] reverseSequence = new StringBuilder(new String(sequence)).reverse().toString().toCharArray();

		// LCS of the given sequence and reverseSequence[] will be the longest
		// palindromic sequence.
		return LongestCommonSubsequence.lcsLength(sequence, reverseSequence);
	}

	public static int lpsLength(char[] sequence) {
		int length = sequence.length;

		// table [i][j] will store lps of sequence[i...j]
		int[][] table = new int[length][length];

		// strings of length 1 are palindrome of length 1
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

	public static int[] lpsUsingLCS(char[] sequence) {

		// Reverse the given sequence and store the reverse in another array
		char[] reverseSequence = new StringBuilder(new String(sequence)).reverse().toString().toCharArray();

		// LCS of the given sequence and reverseSequence[] will be the longest
		// palindromic sequence.
		return LongestCommonSubsequence.lcs(sequence, reverseSequence);
	}

}