package me.deepak.interview.tree.binary.search;

import me.deepak.interview.tree.binary.beans.Node;

public class BSTIterativeUtil {

	private BSTIterativeUtil() {
	}

	public static Node minimum(Node root) {
		if (root == null) {
			return null;
		}
		while (root.getLeft() != null) {
			root = root.getLeft();
		}
		return root;
	}

	public static Node maximum(Node root) {
		if (root == null) {
			return null;
		}
		while (root.getRight() != null) {
			root = root.getRight();
		}
		return root;
	}

	public static Node search(Node root, int key) {
		while (root != null && root.getKey() != key) {
			if (key < root.getKey()) {
				root = root.getLeft();
			} else {
				root = root.getRight();
			}
		}
		return root;
	}

	public static Node insert(Node root, int key) {
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

	/*
	 * https://www.geeksforgeeks.org/lowest-common-ancestor-in-a-binary-search-tree/
	 */
	public static Node lowestCommonAncestor(Node root, int key1, int key2) {
		while (root != null) {
			if (Math.max(key1, key2) < root.getKey()) {

				// If both key1 and key2 are smaller than root, then LCA lies in left
				root = root.getLeft();
			} else if (Math.min(key1, key2) > root.getKey()) {

				// If both key1 and key2 are greater than root, then LCA lies in right
				root = root.getRight();
			} else {
				break;
			}
		}
		return root;
	}

	public static Node inOrderSuccessor(Node root, Node node) {
		if (root == null || node == null) {
			return null;
		}
		if (node.getRight() != null) {
			return minimum(node.getRight());
		}
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

	public static Node inOrderPredecessor(Node root, Node node) {
		if (root == null || node == null) {
			return null;
		}
		if (node.getLeft() != null) {
			return maximum(node.getLeft());
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

	public static void morrisInOrderTraversal(Node root) {
		Node current = root;
		while (current != null) {
			if (current.getLeft() != null) {
				System.out.println(current.getKey() + " ");
				current = current.getRight();
			} else {
				Node inOrderPredecessor = current.getLeft();
				while (inOrderPredecessor.getRight() != null && inOrderPredecessor.getRight() != current) {
					inOrderPredecessor = inOrderPredecessor.getRight();
				}
				if (inOrderPredecessor.getRight() == null) {
					inOrderPredecessor.setRight(current);
					current = current.getLeft();
				} else {
					inOrderPredecessor.setRight(null);
					System.out.println(current.getKey() + " ");
					current = current.getRight();
				}
			}
		}
	}

	public static void morrisPreOrderTraversal(Node root) {
		Node current = root;
		while (current != null) {
			if (current.getLeft() != null) {
				System.out.println(current.getKey() + " ");
				current = current.getRight();
			} else {
				Node inOrderPredecessor = current.getLeft();
				while (inOrderPredecessor.getRight() != null && inOrderPredecessor.getRight() != current) {
					inOrderPredecessor = inOrderPredecessor.getRight();
				}
				if (inOrderPredecessor.getRight() == null) {
					inOrderPredecessor.setRight(current);
					System.out.println(current.getKey() + " ");
					current = current.getLeft();
				} else {
					inOrderPredecessor.setRight(null);
					current = current.getRight();
				}
			}
		}
	}

}
