package me.deepak.interview.leetcode;

import me.deepak.interview.leetcode.beans.TreeNode;

/*
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/
*/

//TODO this problem
public class BinaryTreeMaximumPathSum {

	private static int result = Integer.MIN_VALUE;

	public int maxPathSum(TreeNode root) {
		findMaxSum1(root);
		int temp = result;
		result = Integer.MIN_VALUE;
		return temp;
	}

	private int findMaxSum1(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = findMaxSum1(root.left);
		int right = findMaxSum1(root.right);
		int maxLR = Math.max(left, right);
		int maxSingle = Math.max(maxLR + root.val, root.val);
		int maxAll = Math.max(maxSingle, root.val + left + right);
		result = Math.max(result, maxAll);
		return maxSingle;
	}
}
