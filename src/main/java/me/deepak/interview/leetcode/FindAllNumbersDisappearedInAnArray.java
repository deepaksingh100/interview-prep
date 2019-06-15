package me.deepak.interview.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
 * https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/discuss/92956/Java-accepted-simple-solution
*/
public class FindAllNumbersDisappearedInAnArray {

	public List<Integer> findDisappearedNumbers(int[] nums) {

		List<Integer> result = new ArrayList<>();
		if (nums == null || nums.length == 0) {
			return result;
		}

		int length = nums.length;

		for (int i = 0; i < length; i++) {
			int index = Math.abs(nums[i]) - 1;
			if (nums[index] > 0) {
				nums[index] = -nums[index];
			}
		}

		for (int i = 0; i < length; i++) {
			if (nums[i] > 0) {
				result.add(i + 1);
			}
		}
		return result;
	}

}
