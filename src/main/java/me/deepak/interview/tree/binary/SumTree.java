package me.deepak.interview.tree.binary;

import me.deepak.interview.tree.binary.beans.Node;

/*
 * https://www.geeksforgeeks.org/check-if-a-given-binary-tree-is-sumtree/
*/
public class SumTree {

	private SumTree() {
	}

	// For this method time Complexity: O(n^2) in worst case. Worst case occurs for
	// a skewed tree.
	public static boolean isSumTree(Node root) {
		if (root == null || isLeaf(root)) {
			return true;
		}

		// get sum of nodes in left and right subtrees
		int leftSum = sum(root.getLeft());
		int rightSum = sum(root.getRight());

		// if the node and both of its children satisfy the property return true else
		// false
		return leftSum + rightSum == root.getKey() && isSumTree(root.getLeft()) && isSumTree(root.getRight());
	}

	public static boolean isSumTreeOptimized(Node root) {

		// base case
		if (root == null || isLeaf(root)) {
			return true;
		}

		// if both subtrees are sum tree
		if (isSumTreeOptimized(root.getLeft()) && isSumTreeOptimized(root.getRight())) {

			int leftSum;
			if (root.getLeft() == null) {

				// for null node, sum is 0
				leftSum = 0;
			} else if (isLeaf(root.getLeft())) {

				// for leaf node, sum is key of node
				leftSum = root.getLeft().getKey();
			} else {

				// for other nodes, sum is double key of node
				leftSum = 2 * root.getLeft().getKey();
			}

			int rightSum;
			if (root.getRight() == null) {
				rightSum = 0;
			} else if (isLeaf(root.getRight())) {
				rightSum = root.getRight().getKey();
			} else {
				rightSum = 2 * root.getRight().getKey();
			}

			return leftSum + rightSum == root.getKey();

		}
		return false;

	}

	private static boolean isLeaf(Node root) {
		return root.getLeft() == null && root.getRight() == null;
	}

	private static int sum(Node root) {
		if (root == null) {
			return 0;
		}

		return sum(root.getLeft()) + root.getKey() + sum(root.getRight());

	}

}
