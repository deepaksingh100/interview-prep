package me.deepak.interview.queue;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * https://leetcode.com/problems/sliding-window-maximum/
 * https://youtu.be/39grPZtywyQ
 * https://www.geeksforgeeks.org/sliding-window-maximum-maximum-of-all-subarrays-of-size-k/
*/
public class SlidingWindowMaximum {

	public int[] maxSlidingWindow(int[] a, int k) {
		if (a == null || a.length == 0) {
			return new int[0];
		}
		int n = a.length;
		int[] result = new int[n - k + 1];

		// Create a Double Ended Queue, that will store indexes of array elements.
		// The queue will store indexes of useful elements in every window and it will
		// maintain decreasing order of values from front to rear in Queue.
		Deque<Integer> deque = new ArrayDeque<>();

		// Process first k (or first window) elements of array
		for (int i = 0; i < k; i++) {

			// For every element, the previous smaller elements are useless so
			// remove them from Queue
			while (!deque.isEmpty() && a[deque.peekLast()] < a[i]) {
				deque.removeLast();
			}

			// Add new element at rear of queue
			deque.addLast(i);
		}
		for (int i = k; i < n; i++) {

			// The element at the front of the queue is the largest element of
			// previous window
			result[i - k] = a[deque.peekFirst()];

			// Remove all elements smaller than the currently
			// being added element (remove useless elements)
			while (!deque.isEmpty() && a[deque.peekLast()] < a[i]) {
				deque.removeLast();
			}

			// Remove the elements which are out of this window
			if (!deque.isEmpty() && deque.peekFirst() == i - k) {
				deque.removeFirst();
			}

			// Add current element at the rear of Queue
			deque.addLast(i);
		}

		// add the maximum element of last window to result
		result[n - k] = a[deque.peekFirst()];
		return result;
	}

}
