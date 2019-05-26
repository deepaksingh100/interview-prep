package me.deepak.interview.leetcode;

import me.deepak.interview.leetcode.beans.TreeNode;

/*
 * https://leetcode.com/problems/range-sum-of-bst/
 * https://leetcode.com/articles/range-sum-of-bst/
*/
public class RangeSumBST {

	private int sum;

	public int rangeSumBST(TreeNode root, int l, int r) {
		dfs(root, l, r);
		return sum;
	}

	private void dfs(TreeNode root, int l, int r) {

		if (root != null) {

			if (l < root.val) {
				dfs(root.left, l, r);
			}

			if (r > root.val) {
				dfs(root.right, l, r);
			}

			if (l <= root.val && r >= root.val) {
				sum += root.val;
			}

		}

	}

}
