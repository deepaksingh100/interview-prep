package me.deepak.interview.tree.binary.search;

import me.deepak.interview.tree.binary.beans.Node;

/*
 * https://www.geeksforgeeks.org/binary-search-tree-set-1-search-and-insertion/
 */
public class Insert {

	private Insert() {
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

	public static Node insertIterative(Node root, int key) {
		Node newNode = new Node(key);
		if (root == null) {
			return newNode;
		}
		Node parent = null;
		Node current = root;
		while (current != null) {
			parent = current;
			if (key < current.getKey()) {
				current = current.getLeft();
			} else {
				current = current.getRight();
			}
		}
		if (key < parent.getKey()) {
			parent.setLeft(newNode);
		} else {
			parent.setRight(newNode);
		}
		return root;
	}

}
