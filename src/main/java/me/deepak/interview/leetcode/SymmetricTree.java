package me.deepak.interview.leetcode;

import me.deepak.interview.leetcode.beans.TreeNode;

/*
 * https://leetcode.com/problems/symmetric-tree/
 * https://leetcode.com/articles/symmetric-tree/
*/
public class SymmetricTree {
	public boolean isSymmetric(TreeNode root) {
		return isSymmetric(root, root);
	}

	private boolean isSymmetric(TreeNode root1, TreeNode root2) {
		if (root1 == null && root2 == null) {
			return true;
		}
		if (root1 == null || root2 == null) {
			return false;
		}

		/*
		 * Two trees are a mirror reflection of each other if:
		 * 
		 * 1. Their two roots have the same value.
		 * 
		 * 2. The right subtree of each tree is a mirror reflection of the left subtree
		 * of the other tree.
		 */
		return root1.val == root2.val && isSymmetric(root1.left, root2.right) && isSymmetric(root1.right, root2.left);
	}
}
