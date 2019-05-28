package me.deepak.interview.queue;

import java.util.ArrayDeque;
import java.util.Queue;

/*
 * https://www.geeksforgeeks.org/implement-stack-using-queue/
*/
public class Stack {

	private Stack() {
	}

	private static final Queue<Integer> QUEUE = new ArrayDeque<>();

	public static void push(int a) {
		QUEUE.add(a);
	}

	public static int pop() {
		if (QUEUE.isEmpty()) {
			return -1;
		}
		int size = QUEUE.size();
		while (size-- > 1) {
			QUEUE.add(QUEUE.remove());
		}
		return QUEUE.remove();
	}

}
