package me.deepak.interview.leetcode;

import me.deepak.interview.leetcode.beans.TreeNode;

/*
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/discuss/36977/My-short-post-order-traversal-Java-solution-for-share
*/
public class FlattenBinaryTreeToLinkedList {

	public void flatten(TreeNode root) {
		flatten(root, null);
	}

	private TreeNode flatten(TreeNode root, TreeNode prev) {
		if (root == null) {
			return prev;
		}
		prev = flatten(root.right, prev);
		prev = flatten(root.left, prev);
		root.right = prev;
		root.left = null;
		prev = root;
		return prev;
	}

}
