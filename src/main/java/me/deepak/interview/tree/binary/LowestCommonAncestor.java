package me.deepak.interview.tree.binary;

import me.deepak.interview.tree.binary.beans.Node;

/*
 * https://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/
 */
public class LowestCommonAncestor {

	private LowestCommonAncestor() {
	}

	/*
	 * Note that the this method assumes that keys are present in Binary Tree. If
	 * one key is present and other is absent, then it returns the present key as
	 * LCA (Ideally should have returned NULL).
	 */
	public static Node findLCA(Node root, int key1, int key2) {

		// base case
		if (root == null) {
			return null;
		}

		/*
		 * If either key1 or key2 matches with root's key, report the presence by
		 * returning root (Note that if a key is ancestor of other, then the ancestor
		 * key becomes LCA
		 */
		if (root.getKey() == key1 || root.getKey() == key2) {
			return root;
		}

		// look for keys in left and right subtrees
		Node left = findLCA(root.getLeft(), key1, key2);
		Node right = findLCA(root.getRight(), key1, key2);

		/*
		 * if both of the above calls return non-null, then one key is present in one
		 * subtree and other is present in other, So this node is the LCA
		 */
		if (left != null && right != null) {
			return root;
		}

		// else check if left subtree or right subtree is LCA
		return left != null ? left : right;
	}

	private static class Booleans {
		boolean foundKey1;
		boolean foundKey2;
	}

	public static Node findLCA2(Node root, int key1, int key2) {

		Booleans booleans = new Booleans();
		Node lca = findLCA2(root, key1, key2, booleans);

		// Return LCA only if both key1 and key2 are present in tree
		if (booleans.foundKey1 && booleans.foundKey2) {
			return lca;
		}

		return null;
	}

	private static Node findLCA2(Node root, int key1, int key2, Booleans booleans) {

		// base case
		if (root == null) {
			return null;
		}

		/*
		 * If either key1 or key2 matches with root's key, report the presence by
		 * returning root (Note that if a key is ancestor of other, then the ancestor
		 * key becomes LCA
		 */
		if (root.getKey() == key1) {
			booleans.foundKey1 = true;
			return root;
		}

		if (root.getKey() == key2) {
			booleans.foundKey2 = true;
			return root;
		}

		// look for keys in left and right subtrees
		Node left = findLCA(root.getLeft(), key1, key2);
		Node right = findLCA(root.getRight(), key1, key2);

		/*
		 * if both of the above calls return non-null, then one key is present in one
		 * subtree and other is present in other, So this node is the LCA
		 */
		if (left != null && right != null) {
			return root;
		}

		// else check if left subtree or right subtree is LCA
		return left != null ? left : right;
	}

}
