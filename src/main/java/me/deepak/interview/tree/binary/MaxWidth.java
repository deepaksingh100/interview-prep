package me.deepak.interview.tree.binary;

import java.util.ArrayDeque;
import java.util.Queue;

import me.deepak.interview.tree.binary.beans.Node;

/*
 * https://leetcode.com/problems/maximum-width-of-binary-tree/
 * https://www.geeksforgeeks.org/maximum-width-of-a-binary-tree/
*/
public class MaxWidth {

	private MaxWidth() {
	}

	public static int widthOfBinaryTree(Node root) {
		int maxWidth = 0;
		if (root == null) {
			return maxWidth;
		}

		Queue<Node> queue = new ArrayDeque<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			int size = queue.size();

			maxWidth = Math.max(maxWidth, size);
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
		return maxWidth;
	}

}
