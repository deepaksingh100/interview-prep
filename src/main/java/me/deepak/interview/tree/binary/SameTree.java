package me.deepak.interview.tree.binary;

import java.util.ArrayDeque;
import java.util.Queue;

import me.deepak.interview.tree.binary.beans.Node;

public class SameTree {

	private SameTree() {
	}

	/*
	 * https://www.geeksforgeeks.org/write-c-code-to-determine-if-two-trees-are-
	 * identical/
	 */
	public static boolean isSameTree(Node root1, Node root2) {

		// return true if both trees are empty
		if (root1 == null && root2 == null) {
			return true;
		}

		// return false if one is empty and other is not
		if (root1 == null || root2 == null) {
			return false;
		}

		// if current key's are same, left & right subtrees are same then return true,
		// else false
		return root1.getKey() == root2.getKey() && isSameTree(root1.getLeft(), root2.getLeft())
				&& isSameTree(root1.getRight(), root2.getRight());
	}

	/*
	 * https://www.geeksforgeeks.org/iterative-function-check-two-trees-identical/
	 */
	public static boolean isSameTreeIterative(Node root1, Node root2) {

		// return true if both trees are empty
		if (root1 == null && root2 == null) {
			return true;
		}

		// return false if one is empty and other is not
		if (root1 == null || root2 == null) {
			return false;
		}

		// create 2 empty queues for simultaneous traversals
		Queue<Node> queue1 = new ArrayDeque<>();
		Queue<Node> queue2 = new ArrayDeque<>();

		// enqueue Roots of trees in respective queues
		queue1.add(root1);
		queue2.add(root2);

		while (!queue1.isEmpty() && !queue2.isEmpty()) {

			// remove front nodes and compare them
			root1 = queue1.remove();
			root2 = queue2.remove();

			if (root1.getKey() != root2.getKey()) {
				return false;
			}

			if (root1.getLeft() != null && root2.getLeft() != null) {

				// enqueue left children of both nodes
				queue1.add(root1.getLeft());
				queue2.add(root2.getLeft());
			} else if (root1.getLeft() != null || root2.getLeft() != null) {

				// if one left child is empty and other is not
				return false;
			}

			// right child code (Similar to left child code)
			if (root1.getRight() != null && root2.getRight() != null) {
				queue1.add(root1.getRight());
				queue2.add(root2.getRight());
			} else if (root1.getRight() != null || root2.getRight() != null) {
				return false;
			}
		}

		return true;
	}

}
