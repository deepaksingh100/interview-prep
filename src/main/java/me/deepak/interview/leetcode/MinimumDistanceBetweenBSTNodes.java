package me.deepak.interview.leetcode;

import me.deepak.interview.leetcode.beans.TreeNode;

/*
 * https://leetcode.com/problems/minimum-distance-between-bst-nodes/
 * https://leetcode.com/problems/minimum-absolute-difference-in-bst/discuss/99905/Two-Solutions-in-order-traversal-and-a-more-general-way-using-TreeSet
*/
public class MinimumDistanceBetweenBSTNodes {

	private int min = Integer.MAX_VALUE;
	private Integer prev = null;

	public int minDiffInBST(TreeNode root) {

		if (root == null) {
			return min;
		}

		minDiffInBST(root.left);

		if (prev != null) {
			min = Math.min(min, root.val - prev);
		}
		prev = root.val;

		minDiffInBST(root.right);

		return min;

	}

}
