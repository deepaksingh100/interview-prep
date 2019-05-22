package me.deepak.interview.tree.binary;

import java.util.ArrayDeque;
import java.util.Queue;

import me.deepak.interview.tree.binary.beans.Node;

/*
 * https://leetcode.com/problems/symmetric-tree/
 * https://leetcode.com/articles/symmetric-tree/
*/
public class Symmetric {

	private Symmetric() {
	}

	public static boolean isSymmetric(Node root) {
		return isSymmetric(root, root);
	}

	private static boolean isSymmetric(Node root1, Node root2) {
		if (root1 == null && root2 == null) {
			return true;
		}
		if (root1 == null || root2 == null) {
			return false;
		}

		/*
		 * Two trees are a mirror reflection of each other if:
		 * 
		 * 1. Their two roots have the same value.
		 * 
		 * 2. The right subtree of each tree is a mirror reflection of the left subtree
		 * of the other tree.
		 */
		return root1.getKey() == root2.getKey() && isSymmetric(root1.getLeft(), root2.getRight())
				&& isSymmetric(root1.getRight(), root2.getLeft());
	}

	public static boolean isSymmetricIterative(Node root) {
		Queue<Node> queue = new ArrayDeque<>();
		queue.add(root);
		queue.add(root);
		while (!queue.isEmpty()) {
			Node root1 = queue.remove();
			Node root2 = queue.remove();
			if (root1 == null && root2 == null) {
				continue;
			}
			if (root1 == null || root2 == null) {
				return false;
			}
			if (root1.getKey() != root2.getKey()) {
				return false;
			}
			queue.add(root1.getLeft());
			queue.add(root2.getRight());
			queue.add(root1.getRight());
			queue.add(root2.getLeft());
		}
		return true;
	}

}
