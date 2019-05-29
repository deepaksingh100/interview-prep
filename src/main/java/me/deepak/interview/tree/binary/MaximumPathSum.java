package me.deepak.interview.tree.binary;

import me.deepak.interview.leetcode.beans.TreeNode;

/*
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/
 * https://www.geeksforgeeks.org/find-maximum-path-sum-in-a-binary-tree/
*/
public class MaximumPathSum {

	private int result = Integer.MIN_VALUE;

	public int maxPathSum(TreeNode root) {
		findMaxSum(root);
		return result;
	}

	private int findMaxSum(TreeNode root) {

		// base case
		if (root == null) {
			return 0;
		}

		// leftSum and rightSum store maximum path sum going through left and
		// right child of root respectively
		int leftSum = findMaxSum(root.left);
		int rightSum = findMaxSum(root.right);

		// max path for parent call of root. This path must include at-most one child of
		// root
		int maxSingle = Math.max(Math.max(leftSum, rightSum) + root.val, root.val);

		// maxTop represents the sum when the Node under consideration is the root of
		// the maxSum path and no ancestors of root are there in max sum path.
		int maxTop = Math.max(maxSingle, root.val + leftSum + rightSum);

		// store the Maximum Result.
		result = Math.max(result, maxTop);
		return maxSingle;
	}
}
