package me.deepak.interview.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/problems/next-greater-element-i/
 * https://leetcode.com/problems/next-greater-element-i/discuss/97595/Java-10-lines-linear-time-complexity-O(n)-with-explanation
*/
public class NextGreaterElement1 {

	public int[] nextGreaterElement(int[] nums1, int[] nums2) {

		// map of x to next greater element of x
		Map<Integer, Integer> map = new HashMap<>();
		Deque<Integer> stack = new ArrayDeque<>();
		for (int num : nums2) {

			// we need to keep decreasing stack
			while (!stack.isEmpty() && stack.peek() < num) {
				map.put(stack.pop(), num);
			}
			stack.push(num);
		}
		for (int i = 0; i < nums1.length; i++) {
			nums1[i] = map.getOrDefault(nums1[i], -1);
		}
		return nums1;
	}

}
