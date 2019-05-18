package me.deepak.interview.leetcode;

/*
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
*/
public class SearchInRotatedSortedArray {

	public int search(int[] nums, int target) {
		int low = 0;
		int high = nums.length - 1;

		while (low <= high) {
			
			int mid = (low + high) >>> 1;
			if (target == nums[mid]) {
				return mid;
			}

			if (nums[low] <= nums[mid]) {

				// nums[low ... mid] is sorted
				if (target >= nums[low] && target <= nums[mid]) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			} else {

				// nums[mid + 1 ... high] is sorted
				if (target >= nums[mid] && target <= nums[high]) {
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			}
		}
		return -1;
	}

}
