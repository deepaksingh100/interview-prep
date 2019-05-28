package me.deepak.interview.leetcode;

import me.deepak.interview.leetcode.beans.TreeNode;

/*
 * https://leetcode.com/problems/sum-root-to-leaf-numbers/
 * https://www.geeksforgeeks.org/sum-numbers-formed-root-leaf-paths/
*/
public class SumRootToLeafNumbers {

	public int sumNumbers(TreeNode root) {
		return sumNumbers(root, 0);
	}

	private int sumNumbers(TreeNode root, int val) {

		if (root == null) {
			return 0;
		}

		val = (val * 10) + root.val;

		if (root.left == null && root.right == null) {
			return val;
		}

		return sumNumbers(root.left, val) + sumNumbers(root.right, val);

	}

}
