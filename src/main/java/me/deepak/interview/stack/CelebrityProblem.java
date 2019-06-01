package me.deepak.interview.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * https://www.geeksforgeeks.org/the-celebrity-problem/
*/
public class CelebrityProblem {

	private CelebrityProblem() {
	}

	public static int getId(int[][] acquaintanceMatrix) {

		int peopleCount = acquaintanceMatrix.length;

		Deque<Integer> stack = new ArrayDeque<>();

		// Push every index onto stack
		for (int i = 0; i < peopleCount; i++) {
			stack.push(i);
		}

		// Pop off top two persons from the stack, discard one person based on return
		// status of knows(i, j).
		while (stack.size() > 1) {

			int i = stack.pop();
			int j = stack.pop();

			// Push the remained person onto stack.
			if (knows(acquaintanceMatrix, i, j)) {
				stack.push(j);
			} else {
				stack.push(i);
			}

		}

		int celebrity = stack.pop();

		// Check if the last person is celebrity or not
		for (int i = 0; i < peopleCount; i++) {

			// If any person doesn't know 'celebrity' or 'celebrity' knows at least one
			// person, return -1
			if (celebrity != i
					&& (knows(acquaintanceMatrix, celebrity, i) || !knows(acquaintanceMatrix, i, celebrity))) {
				return -1;
			}
		}

		return celebrity;
	}

	private static boolean knows(int[][] acquaintanceMatrix, int i, int j) {
		return acquaintanceMatrix[i][j] == 1;
	}

}
