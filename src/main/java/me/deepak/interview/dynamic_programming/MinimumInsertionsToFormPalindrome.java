package me.deepak.interview.dynamic_programming;

/*
 * https://www.geeksforgeeks.org/minimum-insertions-to-form-a-palindrome-dp-28/
*/
public class MinimumInsertionsToFormPalindrome {

	private MinimumInsertionsToFormPalindrome() {
	}

	public static int minInsertionsUsingLPS(char[] sequence) {
		return sequence.length - LongestPalindromicSubsequence.lpsLengthUsingLCS(sequence);
	}

	// based on longest palindromic subsequence
	public static int minInsertions(char[] sequence) {
		int length = sequence.length;

		// table [i][j] will store lps of sequence[i...j]
		int[][] table = new int[length][length];

		/*
		 * Build the table. Note that the lower diagonal values of table are useless and
		 * not filled in the process. check for every substring of every length (from 2
		 * to length).
		 */
		for (int l = 2; l <= length; l++) {
			for (int i = 0; i < length - l + 1; i++) {

				// end index of current substring is j. start index is i. length is l.
				int j = i + l - 1;

				if (sequence[i] == sequence[j]) {

					// move both end pointers by one
					table[i][j] = table[i + 1][j - 1];
				} else {

					// min(move left end pointer by one, move right end pointer by one) + 1
					table[i][j] = Math.min(table[i][j - 1], table[i + 1][j]) + 1;
				}
			}
		}
		return table[0][length - 1];
	}

}
