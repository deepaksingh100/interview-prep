package me.deepak.interview.dynamic_programming;

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
		int n = height.length;
		int[] leftHighest = new int[n];
		leftHighest[0] = height[0];
		for (int i = 1; i < n; i++) {
			leftHighest[i] = Math.max(leftHighest[i - 1], height[i]);
		}
		int[] rightHighest = new int[n];
		rightHighest[n - 1] = height[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			rightHighest[i] = Math.max(rightHighest[i + 1], height[i]);
		}
		for (int i = 1; i < n - 1; i++) {
			totalAmount += Math.min(leftHighest[i], rightHighest[i]) - height[i];
		}
		return totalAmount;
	}

}
