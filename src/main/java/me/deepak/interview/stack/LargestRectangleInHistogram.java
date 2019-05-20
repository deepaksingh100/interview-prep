package me.deepak.interview.stack;

import java.util.ArrayDeque;

/*
 * https://leetcode.com/problems/largest-rectangle-in-histogram/
 * https://stackoverflow.com/questions/4311694/maximize-the-rectangular-area-under-histogram
 * https://www.geeksforgeeks.org/largest-rectangle-under-histogram/
*/
public class LargestRectangleInHistogram {

	public int largestRectangleArea(int[] heights) {

		int len = heights.length;

		/*
		 * Create an empty stack. The stack holds indexes of heights[] array. The bars
		 * stored in stack are always in increasing order of their heights.
		 */
		ArrayDeque<Integer> stack = new ArrayDeque<>();

		int maxArea = 0;

		for (int i = 0; i < len; i++) {

			// to maintain increasing stack, pop
			while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {

				int top = stack.pop();

				/*
				 * If this bar is lower than top of stack, then calculate area of rectangle with
				 * stack top as the smallest (or minimum height) bar. 'i' is 'right index' for
				 * the top and element before top in stack is 'left index'
				 */
				int area = heights[top] * (stack.isEmpty() ? i : (i - stack.peek() - 1));
				maxArea = Math.max(maxArea, area);
			}
			stack.push(i);
		}

		int i = len;

		// Now pop the remaining bars from stack and calculate area with every
		// popped bar as the smallest bar
		while (!stack.isEmpty()) {
			int top = stack.pop();
			int area = heights[top] * (stack.isEmpty() ? i : (i - stack.peek() - 1));
			maxArea = Math.max(maxArea, area);
		}
		return maxArea;
	}

}
