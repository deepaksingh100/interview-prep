package me.deepak.interview.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/*
 * https://leetcode.com/problems/daily-temperatures/
*/
public class DailyTemperatures {

	// a close variant of Next Greater Element Problem
	public int[] dailyTemperatures(int[] nums) {
		int length = nums.length;
		int[] result = new int[length];
		Arrays.fill(result, 0);

		// decreasing stack
		Deque<Integer> stack = new ArrayDeque<>();
		for (int i = 0; i < length; i++) {

			// we need to keep decreasing stack
			while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
				int top = stack.pop();

				// diff b/w indexes will be stored
				result[top] = i - top;
			}
			stack.push(i);
		}

		return result;
	}

}
