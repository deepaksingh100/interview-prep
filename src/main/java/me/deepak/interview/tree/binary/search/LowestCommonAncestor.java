package me.deepak.interview.tree.binary.search;

import me.deepak.interview.tree.binary.beans.Node;

/*
 * https://www.geeksforgeeks.org/lowest-common-ancestor-in-a-binary-search-tree/
 */
public class LowestCommonAncestor {

	private LowestCommonAncestor() {
	}

	/*
	 * Given methods assume that both keys are present in given BST. If we are not
	 * sure that keys are present in BST. Then we have to search key1 and key2
	 * before calling findLCA(). If key1 or key2 does not exist in given tree,
	 * return null. Else call findLCA().
	 */
	public static Node findLCA(Node root, int key1, int key2) {

		// base case
		if (root == null) {
			return null;
		}

		// If both key1 and key2 are smaller than root, then LCA lies in left
		if (Math.max(key1, key2) < root.getKey()) {
			return findLCA(root.getLeft(), key1, key2);
		}

		// If both key1 and key2 are greater than root, then LCA lies in right
		if (Math.min(key1, key2) > root.getKey()) {
			return findLCA(root.getRight(), key1, key2);
		}

		return root;
	}

	public static Node findLCAIterative(Node root, int key1, int key2) {
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
