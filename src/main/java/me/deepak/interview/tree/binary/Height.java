package me.deepak.interview.tree.binary;

import java.util.ArrayDeque;
import java.util.Queue;

import me.deepak.interview.tree.binary.beans.Node;

public class Height {

	private Height() {
	}

	/*
	 * https://www.geeksforgeeks.org/write-a-c-program-to-find-the-maximum-depth-or-
	 * height-of-a-tree/
	 */
	public static int getHeight(Node root) {
		if (root == null) {
			return 0;
		}
		return Math.max(getHeight(root.getLeft()), getHeight(root.getRight())) + 1;
	}

	/*
	 * https://www.geeksforgeeks.org/iterative-method-to-find-height-of-binary-tree/
	 */
	public static int getHeightIterative(Node root) {
		if (root == null) {
			return 0;
		}
		Queue<Node> queue = new ArrayDeque<>();
		queue.add(root);

		int height = 0;
		while (!queue.isEmpty()) {
			height++;
			int size = queue.size();
			while (size-- > 0) {
				root = queue.remove();
				if (root.getLeft() != null) {
					queue.add(root.getLeft());
				}
				if (root.getRight() != null) {
					queue.add(root.getRight());
				}
			}
		}
		return height;
	}

}
