package me.deepak.interview.tree.binary;

/*
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/
 * https://www.geeksforgeeks.org/find-maximum-path-sum-in-a-binary-tree/
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/discuss/39775/Accepted-short-solution-in-Java
*/
public class MaximumPathSum {

	private class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
	}

	private int maxSum = Integer.MIN_VALUE;

	public int maxPathSum(TreeNode root) {
		findMaxSum(root);
		return maxSum;
	}

	private int findMaxSum(TreeNode root) {

		// base case
		if (root == null) {
			return 0;
		}

		// leftSum and rightSum store maximum path sum going through left and
		// right child of root respectively. if negative replace it with 0.
		int leftSum = Math.max(0, findMaxSum(root.left));
		int rightSum = Math.max(0, findMaxSum(root.right));

		// store the Maximum Result.
		maxSum = Math.max(maxSum, leftSum + rightSum + root.val);
		return Math.max(leftSum, rightSum) + root.val;
	}
}
