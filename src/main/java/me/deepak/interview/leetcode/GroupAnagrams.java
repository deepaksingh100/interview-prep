package me.deepak.interview.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * https://leetcode.com/problems/group-anagrams/
 * https://leetcode.com/articles/group-anagrams/
*/
public class GroupAnagrams {

	public List<List<String>> groupAnagrams(String[] strs) {
		Map<String, List<String>> map = new HashMap<>();
		for (String str : strs) {
			char[] chars = str.toCharArray();
			Arrays.sort(chars);
			String key = Arrays.toString(chars);
			List<String> anagram = map.get(key);
			if (anagram == null) {
				anagram = new ArrayList<>();
			}
			anagram.add(str);
			map.put(key, anagram);
		}
		return new ArrayList<>(map.values());
	}

}
