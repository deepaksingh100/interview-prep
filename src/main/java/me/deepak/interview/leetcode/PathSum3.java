package me.deepak.interview.leetcode;

import me.deepak.interview.leetcode.beans.TreeNode;

/*
 * https://leetcode.com/problems/path-sum-iii/
*/

//TODO this problem
public class PathSum3 {

	public int pathSum(TreeNode root, int sum) {
		if (root == null) {
			return 0;
		}

		return pathSumFrom(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
	}

	private int pathSumFrom(TreeNode root, int sum) {
		if (root == null) {
			return 0;
		}

		return (sum == root.val ? 1 : 0) + pathSumFrom(root.left, sum - root.val)
				+ pathSumFrom(root.right, sum - root.val);
	}

}
