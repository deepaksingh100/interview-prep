package me.deepak.interview.leetcode;

/*
 * https://leetcode.com/problems/house-robber-ii/
 * https://www.geeksforgeeks.org/maximum-sum-in-circular-array-such-that-no-two-elements-are-adjacent/
*/
public class HouseRobber2 {

	public int rob(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		if (nums.length == 1) {
			return nums[0];
		}
		return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
	}

	private static int rob(int[] a, int low, int high) {
		int incl = a[low];
		int excl = 0;
		for (int i = low + 1; i <= high; i++) {
			int exclNew = Math.max(incl, excl);
			incl = excl + a[i];
			excl = exclNew;
		}
		return Math.max(incl, excl);
	}

}
