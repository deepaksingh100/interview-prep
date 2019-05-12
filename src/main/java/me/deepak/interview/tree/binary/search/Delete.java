package me.deepak.interview.tree.binary.search;

import me.deepak.interview.tree.binary.beans.Node;

/*
 * https://www.geeksforgeeks.org/binary-search-tree-set-2-delete/
*/
public class Delete {

	private Delete() {
	}

	public static Node delete(Node root, int key) {

		// base case
		if (root == null) {
			return root;
		}

		// Otherwise, recur down the tree
		if (key < root.getKey()) {
			root.setLeft(delete(root.getLeft(), key));
		} else if (key > root.getKey()) {
			root.setRight(delete(root.getRight(), key));
		} else {

			// if key is same as root's key, then this is the node to be deleted

			// node with only one child or no child
			if (root.getLeft() == null) {
				return root.getRight();
			} else if (root.getRight() == null) {
				return root.getLeft();
			}

			// node with two children: get the inorder successor (smallest in the right
			// subtree)
			root.setKey(Minimum.getMin(root.getRight()).getKey());

			// delete the inorder successor
			root.setRight(delete(root.getRight(), root.getKey()));
		}
		return root;
	}

}
