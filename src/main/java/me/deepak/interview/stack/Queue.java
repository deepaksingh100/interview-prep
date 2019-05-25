package me.deepak.interview.stack;

import java.util.ArrayDeque;

/*
 * https://www.geeksforgeeks.org/queue-using-stacks/
*/
public class Queue {

	private Queue() {
	}

	private static final ArrayDeque<Integer> STACK1 = new ArrayDeque<>();
	private static final ArrayDeque<Integer> STACK2 = new ArrayDeque<>();

	public static void enqueue(int item) {
		STACK1.push(item);
	}

	public static int dequeue() {
		if (STACK1.isEmpty() && STACK2.isEmpty()) {
			return -1;
		}
		if (STACK2.isEmpty()) {
			while (!STACK1.isEmpty()) {
				STACK2.push(STACK1.pop());
			}
		}
		return STACK2.pop();
	}
}