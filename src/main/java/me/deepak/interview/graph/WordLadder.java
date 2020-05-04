package me.deepak.interview.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/*
 * https://leetcode.com/problems/word-ladder/
 * https://youtu.be/M9cVl4d0v04
 * https://leetcode.com/articles/word-ladder/
 * Asked in Zomato SDE-2 04-05-2020
*/
public class WordLadder {

	// we need to do BFS if src and target are given and shortest path is asked.
	// we need to do DFS when asked for all paths from src to target
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		Set<String> set = new HashSet<>(wordList);
		if (!set.contains(endWord)) {
			return 0;
		}
		Queue<String> queue = new LinkedList<>();
		queue.add(beginWord);
		int level = 1;
		while (!queue.isEmpty()) {
			int size = queue.size();
			while (size-- > 0) {
				String currentWord = queue.remove();
				char[] currentWordChars = currentWord.toCharArray();
				for (int i = 0; i < currentWordChars.length; i++) {
					char originalChar = currentWordChars[i];
					for (char c = 'a'; c <= 'z'; c++) {
						if (currentWordChars[i] != c) {
							currentWordChars[i] = c;
							String newWord = String.valueOf(currentWordChars);
							if (newWord.equals(endWord)) {
								return level + 1;
							}
							if (set.contains(newWord)) {
								queue.add(newWord);
								set.remove(newWord);
							}
						}
					}
					currentWordChars[i] = originalChar;
				}
			}
			level++;
		}
		return 0;
	}

}
