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
		Deque<Integer> stack = new ArrayDeque<>();
		int current = 0;
		int n = height.length;
		while (current < n) {
			while (!stack.isEmpty() && height[current] > height[stack.peek()]) {
				int top = stack.pop();
				if (stack.isEmpty()) {
					break;
				}
				int distance = current - stack.peek() - 1;
				int boundedHeight = Math.min(height[current], height[stack.peek()]) - height[top];
				totalAmount += distance * boundedHeight;
			}
			stack.push(current++);
		}
		return totalAmount;
	}

}
