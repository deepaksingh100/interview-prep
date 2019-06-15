package me.deepak.interview.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/problems/find-all-duplicates-in-an-array/
 * https://leetcode.com/problems/find-all-duplicates-in-an-array/discuss/92387/Java-Simple-Solution
*/
public class FindAllDuplicatesInAnArray {

	public List<Integer> findDuplicates(int[] nums) {

		List<Integer> result = new ArrayList<>();
		if (nums == null || nums.length == 0) {
			return result;
		}

		int length = nums.length;

		for (int i = 0; i < length; i++) {
			int index = Math.abs(nums[i]) - 1;
			if (nums[index] < 0) {
				result.add(index + 1);
			}
			nums[index] = -nums[index];
		}

		return result;
	}

}
