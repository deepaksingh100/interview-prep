package me.deepak.interview.tree.binary;

import static me.deepak.interview.tree.binary.Leaf.isLeaf;

import me.deepak.interview.tree.binary.beans.Node;

/*
 * https://www.geeksforgeeks.org/connect-leaves-doubly-linked-list/
*/
public class ExtractLeavesToDoublyLinkedList {

	private ExtractLeavesToDoublyLinkedList() {
	}

	private static Node head;
	private static Node prev;

	public static Node extract(Node root) {

		if (root == null) {
			return null;
		}

		if (isLeaf(root)) {
			if (head == null) {
				head = root;
			} else {
				prev.setRight(root);
				root.setLeft(prev);
			}
			prev = root;
			return null;
		}

		root.setLeft(extract(root.getLeft()));
		root.setRight(extract(root.getRight()));

		return root;
	}
}
