package me.deepak.interview.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/*
 * https://leetcode.com/problems/next-greater-element-ii/
*/
public class NextGreaterElement2 {

	public int[] nextGreaterElements(int[] nums) {
		int length = nums.length;
		int[] result = new int[length];

		Arrays.fill(result, -1);

		// decreasing stack
		Deque<Integer> stack = new ArrayDeque<>();

		for (int i = 0; i < 2 * length - 1; i++) {
			int j = i % length;

			// we need to keep decreasing stack
			while (!stack.isEmpty() && nums[stack.peek()] < nums[j]) {
				result[stack.pop()] = nums[j];
			}
			stack.push(j);
		}

		return result;
	}

}
