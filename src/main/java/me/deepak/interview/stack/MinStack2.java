package me.deepak.interview.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * https://leetcode.com/problems/min-stack/
 * https://www.geeksforgeeks.org/design-a-stack-that-supports-getmin-in-o1-time-and-o1-extra-space/
*/
public class MinStack2 {

	Deque<Integer> stack = new ArrayDeque<>();
	int min = 0;

	public void push(int x) {
		if (stack.isEmpty()) {
			stack.push(x);
			min = x;
		} else {
			if (x < min) {
				stack.push(2 * x - min);
				min = x;
			} else {
				stack.push(x);
			}
		}
	}

	public int pop() {
		int poppedItem = stack.pop();
		if (poppedItem < min) {
			int cur = min;
			min = 2 * min - poppedItem;
			return cur;
		}
		return poppedItem;
	}

	public int top() {
		int peekedItem = stack.peek();
		return peekedItem < min ? min : peekedItem;
	}

	public int getMin() {
		return min;
	}
}