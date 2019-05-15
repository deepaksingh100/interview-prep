package me.deepak.interview.leetcode;

import me.deepak.interview.leetcode.beans.TreeNode;

/*
 * https://leetcode.com/problems/balanced-binary-tree/
*/
public class BalancedBinaryTree {

	public boolean isBalanced(TreeNode root) {
		if (root == null) {
			return true;
		}
		return isBalanced(root, new Height());
	}

	private boolean isBalanced(TreeNode root, Height height) {
		if (root == null) {
			return true;
		}
		Height lHeight = new Height();
		Height rHeight = new Height();
		boolean isLeftBalanced = isBalanced(root.left, lHeight);
		boolean isRightBalanced = isBalanced(root.right, rHeight);
		int leftHeight = lHeight.h;
		int rightHeight = rHeight.h;
		height.h = Math.max(leftHeight, rightHeight) + 1;
		return Math.abs(leftHeight - rightHeight) <= 1 && isLeftBalanced && isRightBalanced;
	}

	class Height {
		int h = 0;
	}

}
