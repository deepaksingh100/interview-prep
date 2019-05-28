package me.deepak.interview.leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

/*
 * https://leetcode.com/problems/implement-stack-using-queues/
*/
public class ImplementStackUsingQueues {

	Queue<Integer> queue;

	/** Initialize your data structure here. */
	public ImplementStackUsingQueues() {
		queue = new ArrayDeque<>();
	}

	/** Push element x onto stack. */
	public void push(int x) {
		queue.add(x);
	}

	/** Removes the element on top of the stack and returns that element. */
	public int pop() {
		int size = queue.size();
		while (size-- > 1) {
			queue.add(queue.remove());
		}
		return queue.remove();
	}

	/** Get the top element. */
	public int top() {
		int size = queue.size();
		while (size-- > 1) {
			queue.add(queue.remove());
		}
		int top = queue.remove();
		queue.add(top);
		return top;
	}

	/** Returns whether the stack is empty. */
	public boolean empty() {
		return queue.isEmpty();
	}
}
