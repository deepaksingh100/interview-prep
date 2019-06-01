package me.deepak.interview.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import me.deepak.interview.leetcode.beans.TreeNode;

/*
 * https://leetcode.com/problems/binary-tree-right-side-view/
*/
public class BinaryTreeRightSideView {

	public List<Integer> rightSideView(TreeNode root) {
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
