package me.deepak.interview.tree.binary;

import me.deepak.interview.tree.binary.beans.Node;

/*
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/discuss/36977/My-short-post-order-traversal-Java-solution-for-share
*/
public class FlattenBinaryTreeToLinkedList {

	public void flatten(Node root) {
		flatten(root, null);
	}

	private Node flatten(Node root, Node prev) {
		if (root == null) {
			return prev;
		}
		prev = flatten(root.getRight(), prev);
		prev = flatten(root.getLeft(), prev);
		root.setRight(prev);
		root.setLeft(null);
		prev = root;
		return prev;
	}

}
