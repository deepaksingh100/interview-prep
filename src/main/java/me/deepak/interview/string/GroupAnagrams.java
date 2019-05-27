package me.deepak.interview.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * https://leetcode.com/problems/group-anagrams/
 * https://leetcode.com/articles/group-anagrams/
 * https://www.geeksforgeeks.org/given-a-sequence-of-words-print-all-anagrams-together/
*/
public class GroupAnagrams {

	private GroupAnagrams() {
	}

	private static class Word {
		String str;
		int index;

		Word(String str, int index) {
			this.str = str;
			this.index = index;
		}

	}

	public static List<List<String>> groupAnagrams(String[] strs) {
		int length = strs.length;
		Word[] words = new Word[length];
		for (int i = 0; i < length; i++) {
			char[] chars = strs[i].toCharArray();
			Arrays.sort(chars);
			words[i] = new Word(Arrays.toString(chars), i);
		}

		Arrays.sort(words, (Word word1, Word word2) -> word1.str.compareTo(word2.str));
		List<List<String>> anagrams = new ArrayList<>();
		List<String> anagram = new ArrayList<>();
		anagram.add(strs[words[0].index]);

		for (int i = 1; i < length; i++) {
			if (words[i].str.equals(words[i - 1].str)) {
				anagram.add(strs[words[i].index]);
			} else {
				anagrams.add(anagram);
				anagram = new ArrayList<>();
				anagram.add(strs[words[i].index]);
			}
		}

		anagrams.add(anagram);
		return anagrams;

	}

}
