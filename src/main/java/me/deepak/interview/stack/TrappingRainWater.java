package me.deepak.interview.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * https://leetcode.com/problems/trapping-rain-water/
 * https://leetcode.com/articles/trapping-rain-water/
 * https://youtu.be/HmBbcDiJapY
*/
public class TrappingRainWater {

	public int trap(int[] height) {
		int totalAmount = 0;
		if (height == null || height.length == 0) {
			return totalAmount;
		}

		// stack which would always contains decreasing values
		Deque<Integer> stack = new ArrayDeque<>();

		int current = 0;
		int n = height.length;

		while (current < n) {

			// maintain decreasing stack
			while (!stack.isEmpty() && height[stack.peek()] < height[current]) {
				int top = stack.pop();
				if (stack.isEmpty()) {
					break;
				}

				// Find the distance between the current element and the element at top of
				// stack, which is to be filled. Consider stack.peek() as right, current as left
				// & top as current bar
				int distance = current - stack.peek() - 1;

				// min of max of left & right bar minus height of current bar
				int boundedHeight = Math.min(height[current], height[stack.peek()]) - height[top];

				// Add resulting trapped water to answer
				totalAmount += distance * boundedHeight;
			}
			stack.push(current++);
		}
		return totalAmount;
	}

}
