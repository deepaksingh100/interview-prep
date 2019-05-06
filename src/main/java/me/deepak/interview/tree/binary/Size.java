package me.deepak.interview.tree.binary;

import java.util.ArrayDeque;
import java.util.Queue;

import me.deepak.interview.tree.binary.beans.Node;

public class Size {

	private Size() {
	}

	/*
	 * https://www.geeksforgeeks.org/write-a-c-program-to-calculate-size-of-a-tree/
	 */
	public static int getSize(Node root) {
		if (root == null) {
			return 0;
		}
		return getSize(root.getLeft()) + getSize(root.getRight()) + 1;
	}

	/*
	 * https://www.geeksforgeeks.org/iterative-method-to-find-height-of-binary-tree/
	 */
	public static int getSizeIterative(Node root) {
		if (root == null) {
			return 0;
		}
		Queue<Node> queue = new ArrayDeque<>();
		queue.add(root);
		int size = 0;
		while (!queue.isEmpty()) {
			root = queue.remove();
			size++;
			if (root.getLeft() != null) {
				queue.add(root.getLeft());
			}
			if (root.getRight() != null) {
				queue.add(root.getRight());
			}
		}
		return size;
	}

}
