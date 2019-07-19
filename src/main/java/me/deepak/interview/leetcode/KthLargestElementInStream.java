package me.deepak.interview.leetcode;

import java.util.PriorityQueue;

/*
 * https://leetcode.com/problems/kth-largest-element-in-a-stream/
 * https://www.geeksforgeeks.org/kth-largest-element-in-a-stream/
 */
public class KthLargestElementInStream {

	// min heap
	private PriorityQueue<Integer> minHeap;
	private int k;

	public KthLargestElementInStream(int k, int[] nums) {
		this.k = k;
		minHeap = new PriorityQueue<>(k + 1);

		// add all elements of nums to min heap
		for (int i : nums) {
			minHeap.add(i);

			// if size of min heap exceeds k, remove element
			if (minHeap.size() > k) {
				minHeap.remove();
			}
		}
	}

	public int add(int val) {

		// add val to min heap
		minHeap.add(val);

		// if size of min heap exceeds k, remove element
		if (minHeap.size() > k) {
			minHeap.remove();
		}
		return minHeap.peek();
	}

}
