package me.deepak.interview.leetcode;

import me.deepak.interview.leetcode.beans.TreeNode;

/*
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
*/
public class SortedArrayToBST {

	public TreeNode sortedArrayToBST(int[] nums) {
		if (nums == null || nums.length == 0) {
			return null;
		}
		return sortedArrayToBST(nums, 0, nums.length - 1);
	}

	private TreeNode sortedArrayToBST(int[] nums, int low, int high) {
		if (low > high) {
			return null;
		}
		int mid = (low + high) >>> 1;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = sortedArrayToBST(nums, low, mid - 1);
		root.right = sortedArrayToBST(nums, mid + 1, high);
		return root;
	}
}
