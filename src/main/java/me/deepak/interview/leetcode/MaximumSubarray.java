package me.deepak.interview.leetcode;

/*
 * https://leetcode.com/problems/maximum-subarray/
*/
public class MaximumSubarray {

	public int maxSubArray(int[] a) {
		
		int sum = 0;
		int maxSum = Integer.MIN_VALUE;
		for (int i = 0; i < a.length; i++) {
			int currentSum = sum + a[i];
			if (currentSum > maxSum) {
				maxSum = currentSum;
			}
			sum = currentSum;
			if (sum < 0) {
				sum = 0;
			}
		}
		return maxSum;
	}

}
