package me.deepak.interview.string.matching;

import java.util.ArrayList;
import java.util.List;

public class BruteForce {

	/**
	 * Brute force method of pattern matching
	 */
	public List<Integer> bruteForce(char[] text, char[] pattern) {
		List<Integer> matchingIndexes = new ArrayList<>();
		int textIndex = 0;
		int patternIndex = 0;
		int startingIndex = 0;
		while (textIndex < text.length && patternIndex < pattern.length) {
			if (text[textIndex] == pattern[patternIndex]) {
				textIndex++;
				patternIndex++;
			} else {
				patternIndex = 0;
				startingIndex++;
				textIndex = startingIndex;
			}
			if (patternIndex == pattern.length) {
				matchingIndexes.add(startingIndex);
				patternIndex = 0;
				startingIndex++;
				textIndex = startingIndex;
			}
		}
		return matchingIndexes;
	}

}