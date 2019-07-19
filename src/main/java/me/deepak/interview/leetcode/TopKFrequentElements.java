package me.deepak.interview.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/*
 * https://leetcode.com/problems/top-k-frequent-elements/
 * https://leetcode.com/problems/top-k-frequent-elements/discuss/81635/3-Java-Solution-using-Array-MaxHeap-TreeMap
*/
public class TopKFrequentElements {

	public List<Integer> topKFrequent(int[] nums, int k) {

		List<Integer> result = new ArrayList<>();

		if (nums == null || nums.length == 0) {
			return result;
		}

		Map<Integer, Integer> map = new HashMap<>();

		for (int i : nums) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}

		PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(k + 1,
				(entry1, entry2) -> entry1.getValue().compareTo(entry2.getValue()));
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			minHeap.add(entry);
			if (minHeap.size() > k) {
				minHeap.remove();
			}
		}

		while (!minHeap.isEmpty()) {
			result.add(minHeap.remove().getKey());
		}

		return result;

	}

}
