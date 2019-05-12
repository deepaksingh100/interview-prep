package me.deepak.interview.leetcode;

import me.deepak.interview.leetcode.beans.TreeNode;

/*
 * https://leetcode.com/problems/insert-into-a-binary-search-tree/
*/
public class InsertIntoBinarySearchTree {

	private InsertIntoBinarySearchTree() {
	}

	public TreeNode insertIntoBST(TreeNode root, int val) {
		TreeNode newNode = new TreeNode(val);
		if (root == null) {
			return newNode;
		}
		TreeNode parent = null;
		TreeNode current = root;
		while (current != null) {
			parent = current;
			if (val < current.val) {
				current = current.left;
			} else {
				current = current.right;
			}
		}
		if (val < parent.val) {
			parent.left = newNode;
		} else {
			parent.right = newNode;
		}
		return root;
	}

}
