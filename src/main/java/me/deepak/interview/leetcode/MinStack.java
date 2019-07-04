package me.deepak.interview.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * https://leetcode.com/problems/min-stack/
 * https://stackoverflow.com/questions/685060/design-a-stack-such-that-getminimum-should-be-o1
*/
public class MinStack {

	Deque<Integer> stack = new ArrayDeque<>();
	Deque<Integer> minStack = new ArrayDeque<>();

	public void push(int x) {
		stack.push(x);
		if (minStack.isEmpty() || x <= minStack.peek()) {
			minStack.push(x);
		}
	}

	public void pop() {
		int poppedItem = stack.pop();
		if (poppedItem == minStack.peek()) {
			minStack.pop();
		}
	}

	public int top() {
		return stack.peek();
	}

	public int getMin() {
		return minStack.peek();
	}
}