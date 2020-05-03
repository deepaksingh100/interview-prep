package me.deepak.interview.tree.binary;

import me.deepak.interview.tree.binary.beans.Node;

/*
 * https://www.geeksforgeeks.org/in-place-convert-a-given-binary-tree-to-doubly-linked-list/
 * https://www.geeksforgeeks.org/convert-a-given-binary-tree-to-doubly-linked-list-set-2/
 * https://www.geeksforgeeks.org/convert-given-binary-tree-doubly-linked-list-set-3/
*/
public class BinaryTreeToDoublyLinkedList {

	private BinaryTreeToDoublyLinkedList() {
	}

	private static Node head;
	private static Node prev;
	
	public static Node convertBTToDLL(Node root) {
		convert(root);
		return head;
	}

	private static void convert(Node root) {

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
