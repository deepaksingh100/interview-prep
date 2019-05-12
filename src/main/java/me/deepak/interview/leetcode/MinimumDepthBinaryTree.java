package me.deepak.interview.leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

import me.deepak.interview.leetcode.beans.TreeNode;

/*
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/
*/
public class MinimumDepthBinaryTree {

	public int minDepth(TreeNode root) {
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
				if (root.left == null && root.right == null) {
					return depth;
				}
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
