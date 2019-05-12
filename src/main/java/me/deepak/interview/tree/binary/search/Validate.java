package me.deepak.interview.tree.binary.search;

import me.deepak.interview.tree.binary.beans.Node;

/*
 * https://www.geeksforgeeks.org/a-program-to-check-if-a-binary-tree-is-bst-or-not/
*/
public class Validate {

	private Validate() {
	}

	public static boolean isBST(Node root, int min, int max) {

		// an empty tree is BST
		if (root == null) {
			return true;
		}

		// false if this node violates the min/max constraints
		if (root.getKey() < min || root.getKey() > max) {
			return false;
		}

		// otherwise check the subtrees recursively
		return isBST(root.getLeft(), min, root.getKey()) && isBST(root.getRight(), root.getKey(), max);
	}

}
