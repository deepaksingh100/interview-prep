package me.deepak.interview.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import me.deepak.interview.leetcode.beans.TreeNode;

/*
 * https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
*/
public class BinaryTreeLevelOrderTraversal2 {
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		LinkedList<List<Integer>> traversal = new LinkedList<>();
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
			traversal.addFirst(levelTraversal);
		}
		return traversal;
	}
}
