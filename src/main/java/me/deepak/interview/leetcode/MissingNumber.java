package me.deepak.interview.leetcode;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/missing-number/
*/
public class MissingNumber {

	public int missingNumber(int[] nums) {

		int length = nums.length;
		int arrSum = Arrays.stream(nums).sum();
		int sum = length * (length + 1) / 2;
		return sum - arrSum;

	}

}
