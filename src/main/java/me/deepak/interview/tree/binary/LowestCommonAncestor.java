package me.deepak.interview.tree.binary;

import me.deepak.interview.tree.binary.beans.Node;

public class LowestCommonAncestor {

	private LowestCommonAncestor() {
	}

	/*
	 * https://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/
	 */
	public static Node getLCA(Node root, int key1, int key2) {

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
		Node left = getLCA(root.getLeft(), key1, key2);
		Node right = getLCA(root.getRight(), key1, key2);

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
