package me.deepak.interview.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * https://leetcode.com/problems/longest-valid-parentheses/
 * https://leetcode.com/articles/longest-valid-parentheses/
*/
public class LongestValidParentheses {

	/*
	 * Instead of finding every possible string and checking its validity, we can
	 * make use of stack while scanning the given string to check if the string
	 * scanned so far is valid, and also the length of the longest valid string. In
	 * order to do so, we start by pushing -1 onto the stack. For every '('
	 * encountered, we push its index onto the stack. For every ')' encountered, we
	 * pop the topmost element and subtract the current element's index from the top
	 * element of the stack, which gives the length of the currently encountered
	 * valid string of parentheses. If while popping the element, the stack becomes
	 * empty, we push the current element's index onto the stack. In this way, we
	 * keep on calculating the lengths of the valid substrings, and return the
	 * length of the longest valid string at the end.
	 */
	public int longestValidParentheses(String s) {

		// max length
		int maxLength = 0;

		// stack to store indexes
		Deque<Integer> stack = new ArrayDeque<>();

		// push -1 to stack for calculation of max length from start
		stack.push(-1);

		for (int i = 0; i < s.length(); i++) {

			if (s.charAt(i) == '(') {

				// if '(' encountered, push it's index to stack
				stack.push(i);
			} else {

				// if ')' encountered, pop from stack
				stack.pop();

				if (stack.isEmpty()) {

					// if stack is empty, push i to stack for calculation of max length from here on
					stack.push(i);
				} else {

					// if stack is not empty, update max length
					maxLength = Math.max(maxLength, i - stack.peek());
				}
			}
		}

		// return final max length
		return maxLength;
	}

}
