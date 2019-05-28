package me.deepak.interview.tree.binary;

import me.deepak.interview.tree.binary.beans.Node;

/*
 * https://www.geeksforgeeks.org/convert-given-binary-tree-doubly-linked-list-set-3/
*/
public class BinaryTreeToDoublyLinkedList {

	private BinaryTreeToDoublyLinkedList() {
	}

	private static Node head;
	private static Node prev;

	public static void convert(Node root) {

		if (root == null) {
			return;
		}

		convert(root.getLeft());

		if (head == null) {
			head = root;
		} else {
			prev.setRight(root);
			root.setLeft(prev);
		}
		prev = root;

		convert(root.getRight());

	}

}
