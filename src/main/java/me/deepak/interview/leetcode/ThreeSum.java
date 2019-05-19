package me.deepak.interview.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * https://leetcode.com/problems/3sum/
 * https://leetcode.com/problems/3sum/discuss/7399/Easiest-Java-Solution
*/
public class ThreeSum {

	public List<List<Integer>> threeSum(int[] a) {
		Arrays.sort(a);
		int length = a.length;
		List<List<Integer>> triplets = new ArrayList<>();
		for (int i = 0; i < length - 2; i++) {

			if (i > 0 && a[i] == a[i - 1]) { // skip same result
				continue;
			}

			int target = -a[i];
			int start = i + 1;
			int end = length - 1;

			while (start < end) {
				int sum = a[start] + a[end];
				if (sum < target) {
					start++;
				} else if (sum > target) {
					end--;
				} else {
					triplets.add(Arrays.asList(a[start], a[end], a[i]));
					start++;
					end--;
					while (start < end && a[start] == a[start - 1]) {
						start++;
					} // skip same result
					while (start < end && a[end] == a[end + 1]) {
						end--;
					} // skip same result
				}
			}
		}
		return triplets;
	}

}
