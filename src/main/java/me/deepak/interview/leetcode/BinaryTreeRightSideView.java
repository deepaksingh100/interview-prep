package me.deepak.interview.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import me.deepak.interview.leetcode.beans.TreeNode;

/*
 * https://www.geeksforgeeks.org/print-right-view-binary-tree-2/
 * https://leetcode.com/problems/binary-tree-right-side-view/
*/
public class BinaryTreeRightSideView {

	private int maxLevel = 0;

	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> view = new ArrayList<>();
		rightSideView(root, 1, view);
		return view;
	}

	private void rightSideView(TreeNode root, int level, List<Integer> view) {
		if (root == null) {
			return;
		}

		if (maxLevel < level) {
			view.add(root.val);
			maxLevel = level;
		}

		rightSideView(root.right, level + 1, view);
		rightSideView(root.left, level + 1, view);

	}

	public List<Integer> rightSideViewIterative(TreeNode root) {
		List<Integer> rightView = new ArrayList<>();

		if (root == null) {
			return rightView;
		}

		Queue<TreeNode> queue = new ArrayDeque<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			int size = queue.size();

			for (int i = 1; i <= size; i++) {

				root = queue.remove();

				if (i == size) {
					rightView.add(root.val);
				}

				if (root.left != null) {
					queue.add(root.left);
				}

				if (root.right != null) {
					queue.add(root.right);
				}

			}
		}

		return rightView;

	}

}
