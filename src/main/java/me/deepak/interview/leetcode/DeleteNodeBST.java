package me.deepak.interview.leetcode;

import me.deepak.interview.leetcode.beans.TreeNode;

/*
 * https://leetcode.com/problems/delete-node-in-a-bst/
*/
public class DeleteNodeBST {

	public TreeNode deleteNode(TreeNode root, int key) {
		if (root == null) {
			return root;
		}

		if (key < root.val) {
			root.left = deleteNode(root.left, key);
		} else if (key > root.val) {
			root.right = deleteNode(root.right, key);
		} else {
			if (root.left == null) {
				return root.right;
			} else if (root.right == null) {
				return root.left;
			}
			root.val = min(root.right).val;
			root.right = deleteNode(root.right, root.val);
		}

		return root;
	}

	private TreeNode min(TreeNode root) {
		if (root == null || root.left == null) {
			return root;
		}

		return min(root.left);
	}

}
