package me.deepak.interview.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import me.deepak.interview.leetcode.beans.TreeNode;

/*
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
*/
public class BinaryTreeLevelOrderTraversal {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> traversal = new ArrayList<>();
		if (root == null) {
			return traversal;
		}
		Queue<TreeNode> queue = new ArrayDeque<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> levelTraversal = new ArrayList<>();
			while (size-- > 0) {
				root = queue.remove();
				levelTraversal.add(root.val);
				if (root.left != null) {
					queue.add(root.left);
				}
				if (root.right != null) {
					queue.add(root.right);
				}
			}
			traversal.add(levelTraversal);
		}
		return traversal;
	}
}
