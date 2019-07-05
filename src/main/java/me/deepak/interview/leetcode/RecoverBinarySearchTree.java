package me.deepak.interview.leetcode;

import me.deepak.interview.leetcode.beans.TreeNode;

/*
 * https://leetcode.com/problems/recover-binary-search-tree/
 * https://leetcode.com/problems/recover-binary-search-tree/discuss/32535/No-Fancy-Algorithm-just-Simple-and-Powerful-In-Order-Traversal
*/
public class RecoverBinarySearchTree {

	TreeNode first;
	TreeNode second;
	TreeNode prev = new TreeNode(Integer.MIN_VALUE);

	public void recoverTree(TreeNode root) {

		if (root == null) {
			return;
		}

		inOrder(root);

		int temp = first.val;
		first.val = second.val;
		second.val = temp;

	}

	private void inOrder(TreeNode root) {
		if (root != null) {
			inOrder(root.left);

			if (first == null && prev.val > root.val) {
				first = prev;
			}

			if (first != null && prev.val > root.val) {
				second = root;
			}

			prev = root;

			inOrder(root.right);
		}
	}

}
