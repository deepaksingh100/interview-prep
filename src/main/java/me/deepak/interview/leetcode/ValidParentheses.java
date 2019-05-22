package me.deepak.interview.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * https://leetcode.com/problems/valid-parentheses/
 * https://leetcode.com/articles/valid-parentheses/
*/
public class ValidParentheses {
	public boolean isValid(String s) {
		Deque<Character> stack = new ArrayDeque<>();
		for (char c : s.toCharArray()) {
			if (isOpeningBracket(c)) {
				stack.push(c);
			} else {
				if (stack.isEmpty() || c != getClosingBracket(stack.pop())) {
					return false;
				}
			}
		}
		return stack.isEmpty();
	}

	private boolean isOpeningBracket(char c) {
		return c == '(' || c == '{' || c == '[';
	}

	private char getClosingBracket(char c) {
		switch (c) {
		case '(':
			return ')';
		case '{':
			return '}';
		case '[':
			return ']';
		default:
			throw new IllegalArgumentException("Invalid char " + c);

		}
	}

}
