package me.deepak.interview.geeksforgeeks;

import java.util.Arrays;

/*
 * https://www.geeksforgeeks.org/longest-increasing-subarray/
*/

public class LongestIncreasingSubarray {

	private LongestIncreasingSubarray() {
	}

	public static int lisLength(int[] a) {
		/*
		 * 'result' to store the length of longest increasing subarray 'current' to
		 * store the lengths of longest increasing subarray at diiferent instants of
		 * time
		 */
		int result = 1;
		int current = 1;
		for (int i = 1; i < a.length; i++) {
			if (a[i] > a[i - 1]) {
				// current element is greater than it's previous increase 'current'
				current++;
			} else {
				// else update 'result' and 'current'
				result = Math.max(result, current);
				current = 1;
			}
		}
		// return max of 'result' and 'current' as current subarray may be the answer
		return Math.max(result, current);
	}

	public static int[] lis(int[] a) {
		/*
		 * 'result' to store the length of longest increasing subarray 'current' to
		 * store the lengths of longest increasing subarray at diiferent instants of
		 * time. 'start' to store start of result. 'currentStart' to store start of
		 * current subarray.
		 */
		int result = 1;
		int current = 1;
		int start = 0;
		int currentStart = 0;
		for (int i = 1; i < a.length; i++) {
			if (a[i] > a[i - 1]) {
				// If current element is greater than it's previous, increase 'current'
				current++;
			} else {
				// else update 'result', 'start', 'current', 'currentStart'
				if (current > result) {
					result = current;
					start = currentStart;
				}
				current = 1;
				currentStart = i;
			}
		}
		if (current > result) {
			result = current;
			start = currentStart;
		}
		return Arrays.copyOfRange(a, start, start + result);
	}

}
