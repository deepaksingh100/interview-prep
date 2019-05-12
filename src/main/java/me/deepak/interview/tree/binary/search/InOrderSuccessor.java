package me.deepak.interview.tree.binary.search;

import me.deepak.interview.tree.binary.beans.Node;

/*
 * https://www.geeksforgeeks.org/inorder-successor-in-binary-search-tree/
*/
public class InOrderSuccessor {

	private InOrderSuccessor() {
	}

	public static Node inOrderSuccessor(Node root, Node node) {
		if (root == null || node == null) {
			return null;
		}

		// min of right subtree is inorder successor
		if (node.getRight() != null) {
			return Minimum.getMin(node.getRight());
		}

		// go to the nearest ancestor for which given node would be in left subtree.
		Node successor = null;
		while (root != null) {
			if (node.getKey() < root.getKey()) {
				successor = root;
				root = root.getLeft();
			} else if (node.getKey() > root.getKey()) {
				root = root.getRight();
			} else {
				break;
			}
		}
		return successor;
	}

}
