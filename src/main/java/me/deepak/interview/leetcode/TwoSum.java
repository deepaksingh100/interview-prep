package me.deepak.interview.leetcode;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/two-sum/
*/

public class TwoSum {

	public int[] twoSum(int[] nums, int target) {
		int[] results = new int[2];
		int len = nums.length;
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				if (i != j) {
					if (nums[i] + nums[j] == target) {
						results[0] = i;
						results[1] = j;
					}
				}
			}
		}
		Arrays.sort(results);
		return results;
	}

}
