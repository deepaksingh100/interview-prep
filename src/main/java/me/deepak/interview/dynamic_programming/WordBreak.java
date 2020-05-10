package me.deepak.interview.dynamic_programming;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * https://leetcode.com/problems/word-break/
 * https://youtu.be/hLQYQ4zj0qg
*/
public class WordBreak {

	public boolean wordBreakRec(String s, List<String> wordDict) {
		return wordBreakRec(s, new HashSet<>(wordDict));
	}

	private boolean wordBreakRec(String s, Set<String> set) {
		int size = s.length();
		if (size == 0) {
			return true;
		}
		for (int i = 1; i <= size; i++) {
			if (set.contains(s.substring(0, i)) && wordBreakRec(s.substring(i), set)) {
				return true;
			}
		}
		return false;
	}

	public boolean wordBreakMemo(String s, List<String> wordDict) {
		return wordBreakMemo(s, new HashSet<>(wordDict), new HashMap<>());
	}

	private boolean wordBreakMemo(String s, Set<String> set, Map<String, Boolean> map) {
		int size = s.length();
		if (size == 0) {
			return true;
		}

		if (map.containsKey(s)) {
			return map.get(s);
		}

		for (int i = 1; i <= size; i++) {
			if (set.contains(s.substring(0, i)) && wordBreakMemo(s.substring(i), set, map)) {
				map.put(s.substring(i), true);
				return true;
			}
		}
		map.put(s, false);
		return false;
	}

}
