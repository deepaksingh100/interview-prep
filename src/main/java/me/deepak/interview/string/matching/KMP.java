package me.deepak.interview.string.matching;

import java.util.ArrayList;
import java.util.List;

/*
 * https://www.geeksforgeeks.org/kmp-algorithm-for-pattern-searching/
 * 
 * https://youtu.be/GTJr8OvyEVQ
*/
public class KMP {

	/*
	 * https://youtu.be/t4xUA-aHzy8
	 * 
	 * KMP algorithm of pattern matching.
	 */
	public List<Integer> kmp(char[] text, char[] pattern) {

		// compute longest proper prefix which also proper suffix for each substring
		// ending at i
		int[] lps = computeLPS(pattern);

		// matching starting indexes
		List<Integer> matchingIndexes = new ArrayList<>();

		// to loop over text
		int i = 0;

		// to loop over pattern
		int j = 0;

		while (i < text.length && j < pattern.length) {
			if (text[i] == pattern[j]) {

				// trivial case, if current chars matches, advance both pointers by 1
				i++;
				j++;
			}

			if (j == pattern.length) {

				// if whole pattern was matched in text, add pattern's start index in text to
				// answer, reset j to lps[j - 1] to find next match
				matchingIndexes.add(i - j);
				j = lps[j - 1];
			} else if (i < text.length && text[i] != pattern[j]) {

				// mismatch, skip j chars while matching
				if (j != 0) {
					j = lps[j - 1];
				} else {
					i++;
				}
			}
		}
		return matchingIndexes;
	}

	/*
	 * https://youtu.be/tWDUjkMv6Lc
	 * 
	 * Compute LPS to maintain size of longest proper prefix which is also proper
	 * suffix. Time/space complexity is O(size of pattern).
	 */
	private int[] computeLPS(char[] pattern) {
		int length = pattern.length;

		/*
		 * lps[i] DEFENITION : For the substring formed by chars from index 0 to i, it
		 * is length of the longest proper prefix (A proper prefix is prefix with whole
		 * string not allowed.) that is also a proper suffix (A proper suffix is suffix
		 * with whole string not allowed.) in that substring.
		 */
		int[] lps = new int[length];

		// to loop over pattern, lps[0] = 0
		int i = 1;

		// length of longest proper prefix which is also a proper suffix for
		// lps[0...i-1]
		int j = 0;

		// loop on pattern to calculate lps for all i > 0
		while (i < length) {

			if (pattern[i] == pattern[j]) {

				// if pattern[i] == pattern[j], means lps[i] = j + 1
				lps[i++] = ++j;
			} else {

				/*
				 * if pattern[i] != pattern[j], then we need to "find next longest string 'S'"
				 * such that it is a proper prefix and a proper suffix for pattern[0...i-1]
				 * (lps[i]), then update j accordingly and compares pattern[i] and pattern[j].
				 * 
				 * 'S' has to be the longest proper prefix which is also a proper suffix for
				 * pattern[0...j-1] (lps[j - 1]). Thus we need to update j as lps[j - 1].
				 */
				if (j != 0) {
					j = lps[j - 1];
				} else {
					lps[i++] = 0;
				}
			}
		}
		return lps;
	}

}