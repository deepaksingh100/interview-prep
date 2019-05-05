package me.deepak.interview.leetcode;

import me.deepak.interview.leetcode.beans.TreeNode;

/*
 * https://leetcode.com/problems/path-sum/
*/
public class PathSum {
	public boolean hasPathSum(TreeNode root, int sum) {

		if (root == null) {
			return false;
		}

		if (root.left == null && root.right == null) {
			return root.val == sum;
		}

		return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
	}
}
