package me.deepak.interview.tree.binary;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import me.deepak.interview.tree.binary.beans.Node;

/*
 * https://www.geeksforgeeks.org/print-right-view-binary-tree-2/
 * https://leetcode.com/problems/binary-tree-right-side-view/
*/
public class RightSideView {

	private int maxLevel = 0;

	public List<Integer> rightSideView(Node root) {
		List<Integer> view = new ArrayList<>();
		rightSideView(root, 1, view);
		return view;
	}

	private void rightSideView(Node root, int level, List<Integer> view) {
		if (root == null) {
			return;
		}

		if (maxLevel < level) {
			view.add(root.getKey());
			maxLevel = level;
		}

		rightSideView(root.getRight(), level + 1, view);
		rightSideView(root.getLeft(), level + 1, view);

	}

	public List<Integer> rightSideViewIterative(Node root) {
		List<Integer> rightView = new ArrayList<>();

		if (root == null) {
			return rightView;
		}

		Queue<Node> queue = new ArrayDeque<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			int size = queue.size();

			for (int i = 1; i <= size; i++) {

				root = queue.remove();

				if (i == size) {
					rightView.add(root.getKey());
				}

				if (root.getLeft() != null) {
					queue.add(root.getLeft());
				}

				if (root.getRight() != null) {
					queue.add(root.getRight());
				}

			}
		}

		return rightView;

	}

}
