package me.deepak.interview.leetcode;

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
		int left = 0;
		int right = height.length - 1;
		int leftMax = 0;
		int rightMax = 0;
		while (left < right) {
			if (height[left] < height[right]) {
				if (height[left] >= leftMax) {
					leftMax = height[left];
				} else {
					totalAmount += leftMax - height[left];
				}
				left++;
			} else {
				if (height[right] >= rightMax) {
					rightMax = height[right];
				} else {
					totalAmount += rightMax - height[right];
				}
				right--;
			}
		}
		return totalAmount;
	}

}
