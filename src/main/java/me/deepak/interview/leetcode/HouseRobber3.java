package me.deepak.interview.leetcode;

import me.deepak.interview.leetcode.beans.TreeNode;

/*
 * https://leetcode.com/problems/house-robber-iii/
 * https://leetcode.com/problems/house-robber-iii/discuss/79330/Step-by-step-tackling-of-the-problem
*/
public class HouseRobber3 {

	public int rob(TreeNode root) {
		int[] result = robSub(root);
		return Math.max(result[0], result[1]);
	}

	public int[] robSub(TreeNode root) {
		int[] result = new int[2];
		if (root == null) {
			return result;
		}

		int[] left = robSub(root.left);
		int[] right = robSub(root.right);

		// result[1] is when root is selected, result[0] is when not.
		result[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
		result[1] = root.val + left[0] + right[0];

		return result;
	}

}
