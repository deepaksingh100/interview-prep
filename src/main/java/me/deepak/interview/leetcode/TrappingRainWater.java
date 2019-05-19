package me.deepak.interview.leetcode;

/*
 * https://leetcode.com/problems/trapping-rain-water/
*/
public class TrappingRainWater {

	public int trap(int[] height) {
		int totalAmount = 0;
		if (height == null || height.length == 0) {
			return totalAmount;
		}
		int n = height.length;
		int[] leftHighest = new int[n + 1];
		for (int i = 0; i < n; i++) {
			leftHighest[i + 1] = Math.max(leftHighest[i], height[i]);
		}
		int rightHighest = 0;
		for (int i = n - 1; i >= 0; i--) {
			rightHighest = Math.max(rightHighest, height[i]);
			totalAmount += Math.min(leftHighest[i], rightHighest) > height[i]
					? Math.min(leftHighest[i], rightHighest) - height[i]
					: 0;
		}
		return totalAmount;
	}

}
