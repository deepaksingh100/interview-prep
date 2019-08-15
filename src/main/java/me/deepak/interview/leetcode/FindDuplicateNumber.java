package me.deepak.interview.leetcode;

/*
 * https://leetcode.com/problems/find-the-duplicate-number/
*/
public class FindDuplicateNumber {

	public int findDuplicate(int[] nums) {

		// Find the intersection point of the two runners.
		int slow = nums[0];
		int fast = nums[0];
		do {
			slow = nums[slow];
			fast = nums[nums[fast]];
		} while (slow != fast);

		// Find the "entrance" to the cycle.
		int ptr1 = nums[0];
		int ptr2 = slow;
		while (ptr1 != ptr2) {
			ptr1 = nums[ptr1];
			ptr2 = nums[ptr2];
		}

		return ptr1;
	}

}
