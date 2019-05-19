package me.deepak.interview.leetcode;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/3sum-closest/
 * https://leetcode.com/problems/3sum-closest/discuss/7872/Java-solution-with-O(n2)-for-reference
*/
public class ThreeSumClosest {

	public int threeSumClosest(int[] nums, int target) {
		int length = nums.length;
		int result = nums[0] + nums[1] + nums[2];
		Arrays.sort(nums);
		for (int i = 0; i < length - 2; i++) {
			int start = i + 1;
			int end = length - 1;
			while (start < end) {
				int sum = nums[i] + nums[start] + nums[end];
				if (sum < target) {
					start++;
				} else {
					end--;
				}
				if (Math.abs(target - sum) < Math.abs(target - result)) {
					result = sum;
				}
			}
		}
		return result;
	}

}
