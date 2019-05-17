package me.deepak.interview.leetcode;

import java.util.ArrayDeque;

/*
 * https://leetcode.com/problems/largest-rectangle-in-histogram/
*/

//TODO this problem
public class LargestRectangleInHistogram {

	public int largestRectangleArea(int[] heights) {
		int len = heights.length;
		ArrayDeque<Integer> stack = new ArrayDeque<>();
		int maxArea = 0;
		for (int i = 0; i < len; i++) {
			while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
				int poppedItem = stack.pop();
				int area = heights[poppedItem] * (stack.isEmpty() ? i : (i - stack.peek() - 1));
				if (area > maxArea)
					maxArea = area;
			}
			stack.push(i);
		}
		int i = len;
		while (!stack.isEmpty()) {
			int poppedItem = stack.pop();
			int area = heights[poppedItem] * (stack.isEmpty() ? i : (i - stack.peek() - 1));
			if (area > maxArea)
				maxArea = area;
		}
		return maxArea;
	}

}
