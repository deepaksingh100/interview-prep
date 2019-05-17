package me.deepak.interview.leetcode;

/*
 * https://leetcode.com/problems/maximum-length-of-repeated-subarray/
*/
public class MaximumLengthOfRepeatedSubarray {

	public int findLength(int[] a, int[] b) {
		int len1 = a.length;
		int len2 = b.length;
		int max = 0;
		int[][] table = new int[len1 + 1][len2 + 1];
		for (int i = 0; i <= len1; i++) {
			for (int j = 0; j <= len2; j++) {
				if (i == 0 || j == 0) {
					table[i][j] = 0;
				} else if (a[i - 1] == b[j - 1]) {
					table[i][j] = table[i - 1][j - 1] + 1;
					max = Math.max(max, table[i][j]);
				}
			}
		}
		return max;
	}

}
