package me.deepak.interview.string;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/valid-anagram/
 * https://leetcode.com/articles/valid-anagram/
*/
public class ValidAnagram {

	private ValidAnagram() {
	}

	public static boolean isAnagram(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		char[] c1 = s.toCharArray();
		char[] c2 = t.toCharArray();
		Arrays.sort(c1);
		Arrays.sort(c2);
		return Arrays.equals(c1, c2);
	}

	public static boolean isAnagram2(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		int[] counter = new int[26];
		for (int i = 0; i < s.length(); i++) {
			counter[s.charAt(i) - 'a']++;
			counter[t.charAt(i) - 'a']++;
		}
		for (int i = 0; i < 26; i++) {
			if (counter[i] != 0) {
				return false;
			}
		}
		return true;
	}

}
