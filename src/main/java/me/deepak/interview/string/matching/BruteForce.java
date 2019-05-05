package me.deepak.interview.string.matching;

import java.util.ArrayList;
import java.util.List;

/*
 * https://www.geeksforgeeks.org/naive-algorithm-for-pattern-searching/
*/
public class BruteForce {

	public List<Integer> match(char[] text, char[] pattern) {

		// matching starting indexes
		List<Integer> matchingIndexes = new ArrayList<>();

		// to loop over text
		int textIndex = 0;

		// to loop over pattern
		int patternIndex = 0;

		// to check from every index in text, if pattern can be found
		int startingIndex = 0;

		while (textIndex < text.length && patternIndex < pattern.length) {

			if (text[textIndex] == pattern[patternIndex]) {

				// if current chars matches, advance both pointers by 1
				textIndex++;
				patternIndex++;
			} else {

				// reset patternIndex to 0, advance starting index of text by 1 & reset
				// textIndex from startingIndex
				patternIndex = 0;
				textIndex = ++startingIndex;
			}

			// if whole pattern is found, add startingIndex to the answer & reset
			// patternIndex and textIndex
			if (patternIndex == pattern.length) {
				matchingIndexes.add(startingIndex);
				patternIndex = 0;
				textIndex = ++startingIndex;
			}
		}
		return matchingIndexes;
	}

}