package me.deepak.interview.leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

import me.deepak.interview.leetcode.beans.TreeNode;

/*
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
*/
public class MaximumDepthBinaryTree {

	public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		Queue<TreeNode> queue = new ArrayDeque<>();
		queue.add(root);

		int depth = 0;
		while (!queue.isEmpty()) {
			depth++;
			int size = queue.size();
			while (size-- > 0) {
				root = queue.remove();
				if (root.left != null) {
					queue.add(root.left);
				}
				if (root.right != null) {
					queue.add(root.right);
				}
			}
		}
		return depth;
	}

}
