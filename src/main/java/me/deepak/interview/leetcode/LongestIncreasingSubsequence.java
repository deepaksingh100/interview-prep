package me.deepak.interview.leetcode;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/longest-increasing-subsequence/
*/
public class LongestIncreasingSubsequence {

	public int lengthOfLIS(int[] arr) {
		int length = arr.length;
		int[] lisLengths = new int[length];

		// Initialize LIS values for all indexes
		Arrays.fill(lisLengths, 1);

		/*
		 * Compute optimized LIS values in bottom up manner. if arr[i] > arr[j], then
		 * lis[i] = max(lis[i], lis[j] + 1)
		 * 
		 */
		for (int i = 1; i < length; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j]) {
					lisLengths[i] = Math.max(lisLengths[i], lisLengths[j] + 1);
				}
			}
		}

		// Pick maximum of all LIS values
		return Arrays.stream(lisLengths).max().getAsInt();
	}

}
