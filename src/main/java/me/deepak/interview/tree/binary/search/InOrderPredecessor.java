package me.deepak.interview.tree.binary.search;

import me.deepak.interview.tree.binary.beans.Node;

public class InOrderPredecessor {

	private InOrderPredecessor() {
	}

	public static Node inOrderPredecessor(Node root, Node node) {
		if (root == null || node == null) {
			return null;
		}
		if (node.getLeft() != null) {
			return Maximum.getMax(node.getLeft());
		}
		Node predecessor = null;
		while (root != null) {
			if (node.getKey() < root.getKey()) {
				root = root.getLeft();
			} else if (node.getKey() > root.getKey()) {
				predecessor = root;
				root = root.getRight();
			} else {
				break;
			}
		}
		return predecessor;
	}

}
