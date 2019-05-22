package me.deepak.interview.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * https://leetcode.com/problems/valid-parentheses/
 * https://leetcode.com/articles/valid-parentheses/
*/
public class ValidParentheses {

	public boolean isValid(String s) {

		// stack which stores only opening brackets
		Deque<Character> stack = new ArrayDeque<>();

		for (char c : s.toCharArray()) {

			if (isOpeningBracket(c)) {

				// if current char is a opening bracket, push it to stack
				stack.push(c);
			} else {

				// if current char is a closing bracket, pop from stack, get corresponding
				// closing bracket and match
				if (stack.isEmpty() || c != getClosingBracket(stack.pop())) {
					return false;
				}
			}
		}

		// if stack is not empty, then parentheses is not valid
		return stack.isEmpty();
	}

	// checks if given char is opening bracket
	private boolean isOpeningBracket(char c) {
		return c == '(' || c == '{' || c == '[';
	}

	// returns closing bracket of given opening bracket
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
