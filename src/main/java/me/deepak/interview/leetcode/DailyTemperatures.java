package me.deepak.interview.leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/*
 * https://leetcode.com/problems/daily-temperatures/
*/
public class DailyTemperatures {

	public int[] dailyTemperatures(int[] nums) {
		int length = nums.length;
		int[] result = new int[length];
		Arrays.fill(result, 0);
		Deque<Integer> stack = new ArrayDeque<>();
		for (int i = 0; i < length; i++) {

			// we need to keep decreasing stack
			while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
				int top = stack.pop();
				result[top] = i - top;
			}
			stack.push(i);
		}

		return result;
	}

}
