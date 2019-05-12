package me.deepak.interview.tree.binary.search;

import me.deepak.interview.tree.binary.beans.Node;

/*
 * https://www.geeksforgeeks.org/binary-search-tree-set-1-search-and-insertion/
 */
public class Search {

	private Search() {
	}

	public static Node search(Node root, int key) {
		if (root == null || key == root.getKey()) {
			return root;
		}
		if (key < root.getKey()) {
			return search(root.getLeft(), key);
		}
		return search(root.getRight(), key);
	}

	public static Node searchIterative(Node root, int key) {
		while (root != null && root.getKey() != key) {
			if (key < root.getKey()) {
				root = root.getLeft();
			} else {
				root = root.getRight();
			}
		}
		return root;
	}

}
