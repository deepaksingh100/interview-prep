package me.deepak.interview.tree.binary.search;

import me.deepak.interview.tree.binary.beans.Node;

/*
 * https://www.geeksforgeeks.org/lowest-common-ancestor-in-a-binary-search-tree/
 */
public class LowestCommonAncestor {

	private LowestCommonAncestor() {
	}

	public static Node getLCA(Node root, int key1, int key2) {

		if (root == null) {

			// base case
			return null;
		} else if (Math.max(key1, key2) < root.getKey()) {

			// If both key1 and key2 are smaller than root, then LCA lies in left
			return getLCA(root.getLeft(), key1, key2);
		} else if (Math.min(key1, key2) > root.getKey()) {

			// If both key1 and key2 are greater than root, then LCA lies in right
			return getLCA(root.getRight(), key1, key2);
		}
		return root;
	}
	
	public static Node getLCAIterative(Node root, int key1, int key2) {
		while (root != null) {
			if (Math.max(key1, key2) < root.getKey()) {

				// If both key1 and key2 are smaller than root, then LCA lies in left
				root = root.getLeft();
			} else if (Math.min(key1, key2) > root.getKey()) {

				// If both key1 and key2 are greater than root, then LCA lies in right
				root = root.getRight();
			} else {
				break;
			}
		}
		return root;
	}

}
