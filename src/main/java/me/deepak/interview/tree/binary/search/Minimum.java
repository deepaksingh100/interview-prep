package me.deepak.interview.tree.binary.search;

import me.deepak.interview.tree.binary.beans.Node;

/*
 * https://www.geeksforgeeks.org/find-the-minimum-element-in-a-binary-search-
 * tree/
 */
public class Minimum {

	private Minimum() {
	}

	public static Node getMin(Node root) {
		if (root == null || root.getLeft() == null) {
			return root;
		}
		return getMin(root.getLeft());
	}

	public static Node getMinIterative(Node root) {
		if (root == null) {
			return null;
		}
		while (root.getLeft() != null) {
			root = root.getLeft();
		}
		return root;
	}

}
