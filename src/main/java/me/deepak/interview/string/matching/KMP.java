package me.deepak.interview.string.matching;

import java.util.ArrayList;
import java.util.List;

public class KMP {

	/**
	 * KMP algorithm of pattern matching.
	 */
	public List<Integer> kmp(char[] text, char[] pattern) {
		int[] lps = computeLPS(pattern);
		List<Integer> matchingIndexes = new ArrayList<>();
		int textIndex = 0;
		int patternIndex = 0;
		while (textIndex < text.length && patternIndex < pattern.length) {
			if (text[textIndex] == pattern[patternIndex]) {
				textIndex++;
				patternIndex++;
			}
			if (patternIndex == pattern.length) {
				matchingIndexes.add(textIndex - patternIndex);
				patternIndex = lps[patternIndex - 1];
			} else if (textIndex < text.length && text[textIndex] != pattern[patternIndex]) {
				if (patternIndex != 0) {
					patternIndex = lps[patternIndex - 1];
				} else {
					textIndex++;
				}
			}
		}
		return matchingIndexes;
	}

	/**
	 * Compute LPS to maintain size of longest prefix which is also suffix
	 * Time/space complexity is O(size of pattern)
	 */
	private int[] computeLPS(char[] pattern) {
		int[] lps = new int[pattern.length];
		int previousLPSLength = 0; // length of the previous longest prefix suffix
		int patternIndex = 1;
		while (patternIndex < pattern.length) {
			if (pattern[patternIndex] == pattern[previousLPSLength]) {
				lps[patternIndex++] = ++previousLPSLength;
			} else {
				if (previousLPSLength != 0) {
					previousLPSLength = lps[previousLPSLength - 1];
				} else {
					lps[patternIndex++] = 0;
				}
			}
		}
		return lps;
	}

}