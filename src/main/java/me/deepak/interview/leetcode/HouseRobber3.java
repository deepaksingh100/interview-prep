package me.deepak.interview.leetcode;

import me.deepak.interview.leetcode.beans.TreeNode;

/*
 * https://leetcode.com/problems/house-robber-iii/
*/

public class HouseRobber3 {

	public int rob(TreeNode root) {
		if (root == null)
			return 0;

		int[] result = helper(root);
		return Math.max(result[0], result[1]);
	}

	public int[] helper(TreeNode root) {
		int[] result = new int[2];
		if (root == null) {
			return result;
		}

		int[] left = helper(root.left);
		int[] right = helper(root.right);

		// result[0] is when root is selected, result[1] is when not.
		result[0] = root.val + left[1] + right[1];
		result[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

		return result;
	}

}
