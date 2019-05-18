package me.deepak.interview.tree.binary.search;

import me.deepak.interview.tree.binary.beans.Node;

/*
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
*/
public class SortedArrayToBST {

	public Node sortedArrayToBST(int[] nums) {
		if (nums == null || nums.length == 0) {
			return null;
		}
		return sortedArrayToBST(nums, 0, nums.length - 1);
	}

	private Node sortedArrayToBST(int[] nums, int low, int high) {
		if (low > high) {
			return null;
		}
		int mid = (low + high) >>> 1;
		Node root = new Node(nums[mid]);
		root.setLeft(sortedArrayToBST(nums, low, mid - 1));
		root.setRight(sortedArrayToBST(nums, mid + 1, high));
		return root;
	}
}
