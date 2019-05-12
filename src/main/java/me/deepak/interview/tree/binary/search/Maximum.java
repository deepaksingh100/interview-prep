package me.deepak.interview.tree.binary.search;

import me.deepak.interview.tree.binary.beans.Node;

/*
 * https://www.geeksforgeeks.org/find-the-node-with-maximum-value-in-a-binary-
 * search-tree/
 */
public class Maximum {

	private Maximum() {
	}

	public static Node getMax(Node root) {
		if (root == null || root.getRight() == null) {
			return root;
		}
		return getMax(root.getRight());
	}

	public static Node getMaxIterative(Node root) {
		if (root == null) {
			return null;
		}
		while (root.getRight() != null) {
			root = root.getRight();
		}
		return root;
	}

}
