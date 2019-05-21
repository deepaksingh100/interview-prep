package me.deepak.interview.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * https://leetcode.com/problems/sliding-window-maximum/
*/
public class SlidingWindowMaximum {

	public int[] maxSlidingWindow(int[] a, int k) {
		if (a == null || a.length == 0) {
			return new int[0];
		}
		int n = a.length;
		int[] result = new int[n - k + 1];
		Deque<Integer> deque = new ArrayDeque<>();
		for (int i = 0; i < k; i++) {
			while (!deque.isEmpty() && a[deque.peekLast()] <= a[i]) {
				deque.removeLast();
			}
			deque.addLast(i);
		}
		for (int i = k; i < n; i++) {
			result[i - k] = a[deque.peekFirst()];
			while (!deque.isEmpty() && a[deque.peekLast()] <= a[i]) {
				deque.removeLast();
			}
			while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
				deque.removeFirst();
			}
			deque.addLast(i);
		}
		result[n - k] = a[deque.peekFirst()];
		return result;
	}

}
