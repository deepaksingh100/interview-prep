package me.deepak.interview.tree.binary.search;

import me.deepak.interview.tree.binary.beans.Node;

/*
 * https://leetcode.com/problems/recover-binary-search-tree/
 * https://leetcode.com/problems/recover-binary-search-tree/discuss/32535/No-Fancy-Algorithm-just-Simple-and-Powerful-In-Order-Traversal
*/
public class RecoverBinarySearchTree {

	Node first;
	Node second;
	Node prev = new Node(Integer.MIN_VALUE);

	public void recoverTree(Node root) {

		if (root == null) {
			return;
		}

		inOrder(root);

		int temp = first.getKey();
		first.setKey(second.getKey());
		second.setKey(temp);

	}

	private void inOrder(Node root) {
		if (root != null) {
			inOrder(root.getLeft());

			if (first == null && prev.getKey() > root.getKey()) {
				first = prev;
			}

			if (first != null && prev.getKey() > root.getKey()) {
				second = root;
			}

			prev = root;

			inOrder(root.getRight());
		}
	}

}
