package me.deepak.interview.geeksforgeeks;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
 * https://www.geeksforgeeks.org/maximum-distinct-elements-removing-k-elements/
*/
public class MaximumDistinctElementsAfterRemovingKElements {

	private MaximumDistinctElementsAfterRemovingKElements() {
	}

	public static int count(int[] a, int k) {

		Map<Integer, Integer> map = new HashMap<>();
		for (int i : a) {
			int val = map.getOrDefault(i, 0);
			map.put(i, ++val);
		}

		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		for (int val : map.values()) {
			maxHeap.add(val);
		}

		while (k-- > 0) {
			int val = maxHeap.remove();
			val--;
			if (val > 0) {
				maxHeap.add(val);
			}
		}
		return maxHeap.size();

	}

}
