package me.deepak.interview.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import me.deepak.interview.leetcode.beans.TreeNode;

/*
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
*/
public class BinaryTreeZigzagLevelOrderTraversal {

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> traversal = new ArrayList<>();
		if (root == null) {
			return traversal;
		}

		Deque<TreeNode> deque = new ArrayDeque<>();
		deque.add(root);
		boolean evenLevel = true;

		while (!deque.isEmpty()) {

			int size = deque.size();
			List<Integer> levelTraversal = new ArrayList<>();

			if (evenLevel) {

				while (size-- > 0) {
					root = deque.remove();
					levelTraversal.add(root.val);
					
					if (root.left != null) {
						deque.add(root.left);
					}
					if (root.right != null) {
						deque.add(root.right);
					}
				}

			} else {

				while (size-- > 0) {
					root = deque.removeLast();
					levelTraversal.add(root.val);

					if (root.right != null) {
						deque.addFirst(root.right);
					}
					if (root.left != null) {
						deque.addFirst(root.left);
					}
				}

			}

			traversal.add(levelTraversal);
			evenLevel = !evenLevel;
		}

		return traversal;

	}

}
