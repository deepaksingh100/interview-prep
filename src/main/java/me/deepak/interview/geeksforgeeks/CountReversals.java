package me.deepak.interview.geeksforgeeks;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * https://www.geeksforgeeks.org/minimum-number-of-bracket-reversals-needed-to-make-an-expression-balanced/
*/
public class CountReversals {

	private CountReversals() {
	}

	// This method count minimum reversal for making an expression balanced. Returns
	// -1 if expression cannot be balanced.
	public static int countReversals(char[] chars) {
		int length = chars.length;

		// length of expression must be even to make it balanced by using reversals.
		if ((length & 1) != 0) {
			return -1;
		}

		// After this loop, stack contains unbalanced part of expression, i.e.,
		// expression of the form "}}..}{{..{"
		Deque<Character> stack = new ArrayDeque<>();
		for (char c : chars) {
			if (c == '}' && !stack.isEmpty()) {
				if (stack.peek() == '{') {
					stack.pop();
				} else {
					stack.push(c);
				}
			} else {
				stack.push(c);
			}
		}

		// Length of the reduced expression reducedLength = (m+n)
		int reducedLength = stack.size();
		int m = 0;

		// count opening brackets at the end of stack
		while (!stack.isEmpty() && stack.pop() == '{') {
			m++;
		}

		int n = reducedLength - m;
		return (int) (Math.ceil((double) m / 2) + Math.ceil((double) n / 2));

	}

}
