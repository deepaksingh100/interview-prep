package me.deepak.interview.geeksforgeeks;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

/*
 * https://www.geeksforgeeks.org/print-all-jumping-numbers-smaller-than-or-equal-to-a-given-value/
*/
public class JumpingNumbers {

	private JumpingNumbers() {
	}

	public static List<Integer> jumpingNumbers(int end) {
		List<Integer> jumpingNumbers = new ArrayList<>();
		jumpingNumbers.add(0);
		for (int i = 1; i <= 9 && i <= end; i++) {
			jumpingNumbers(i, end, jumpingNumbers);
		}
		Collections.sort(jumpingNumbers);
		return jumpingNumbers;
	}

	private static void jumpingNumbers(int start, int end, List<Integer> jumpingNumbers) {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(start);
		while (!queue.isEmpty()) {
			int jumpingNumber = queue.remove();
			if (jumpingNumber <= end) {
				jumpingNumbers.add(jumpingNumber);
				int lastDigit = jumpingNumber % 10;
				if (lastDigit != 9) {
					queue.add(jumpingNumber * 10 + lastDigit + 1);
				}
				if (lastDigit != 0) {
					queue.add(jumpingNumber * 10 + lastDigit - 1);
				}
			}
		}
	}

}
