package me.deepak.interview.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * https://leetcode.com/problems/find-median-from-data-stream/
*/
public class FindMedianFromDataStream {

	PriorityQueue<Integer> minHeap = null;
	PriorityQueue<Integer> maxHeap = null;

	public FindMedianFromDataStream() {
		minHeap = new PriorityQueue<>();
		maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
	}

	public void addNum(int num) {
		minHeap.add(num);
		maxHeap.add(minHeap.remove());
		if (minHeap.size() < maxHeap.size()) {
			minHeap.add(maxHeap.remove());
		}
	}

	public double findMedian() {
		if (minHeap.size() > maxHeap.size()) {
			return minHeap.peek();
		}
		return (minHeap.peek() + maxHeap.peek()) / 2.0;
	}

}
