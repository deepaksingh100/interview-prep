package me.deepak.interview.tree.binary.search;

import me.deepak.interview.tree.binary.beans.Node;

public class BSTRecursiveUtil {

	private BSTRecursiveUtil() {
	}

	public static Node minimum(Node root) {
		if (root == null) {
			return null;
		}
		if (root.getLeft() == null) {
			return root;
		}
		return minimum(root.getLeft());
	}

	public static Node maximum(Node root) {
		if (root == null) {
			return null;
		}
		if (root.getRight() == null) {
			return root;
		}
		return maximum(root.getRight());
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

	public static Node insert(Node root, int key) {
		if (root == null) {
			return new Node(key);
		}
		if (key < root.getKey()) {
			root.setLeft(insert(root.getLeft(), key));
		} else {
			root.setRight(insert(root.getRight(), key));
		}
		return root;
	}

	public static Node delete(Node root, int key) {
		if (root == null) {
			return root;
		}
		if (key < root.getKey()) {
			root.setLeft(delete(root.getLeft(), key));
		} else if (key > root.getKey()) {
			root.setRight(delete(root.getRight(), key));
		} else {
			if (root.getLeft() == null) {
				return root.getRight();
			} else if (root.getRight() == null) {
				return root.getLeft();
			}
			root.setKey(minimum(root.getRight()).getKey());
			root.setRight(delete(root.getRight(), root.getKey()));
		}
		return root;
	}

	public static boolean isBST(Node root, int min, int max) {
		if (root == null) {
			return true;
		}
		if (root.getKey() < min || root.getKey() > max) {
			return false;
		}
		return isBST(root.getLeft(), min, root.getKey()) && isBST(root.getRight(), root.getKey(), max);
	}

	/*
	 * https://www.geeksforgeeks.org/lowest-common-ancestor-in-a-binary-search-tree/
	 */
	public static Node lowestCommonAncestor(Node root, int key1, int key2) {

		if (root == null) {

			// base case
			return null;
		} else if (Math.max(key1, key2) < root.getKey()) {

			// If both key1 and key2 are smaller than root, then LCA lies in left
			return lowestCommonAncestor(root.getLeft(), key1, key2);
		} else if (Math.min(key1, key2) > root.getKey()) {

			// If both key1 and key2 are greater than root, then LCA lies in right
			return lowestCommonAncestor(root.getRight(), key1, key2);
		}
		return root;
	}

	public static int distance(Node root, int key1, int key2) {
		Node lca = lowestCommonAncestor(root, key1, key2);
		return distanceFromRoot(lca, key1) + distanceFromRoot(lca, key2);
	}

	private static int distanceFromRoot(Node root, int key) {
		if (root == null) {
			return 0;
		}
		if (root.getKey() == key) {
			return 0;
		} else if (root.getKey() > key) {
			return 1 + distanceFromRoot(root.getLeft(), key);
		}
		return 1 + distanceFromRoot(root.getRight(), key);
	}

}
