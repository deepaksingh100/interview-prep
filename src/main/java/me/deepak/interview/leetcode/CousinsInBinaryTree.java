package me.deepak.interview.leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

import me.deepak.interview.leetcode.beans.TreeNode;

/*
 * https://leetcode.com/problems/cousins-in-binary-tree/
 * https://leetcode.com/problems/cousins-in-binary-tree/discuss/239376/Java-BFS-time-and-space-beat-100
*/
public class CousinsInBinaryTree {

	public boolean isCousins(TreeNode root, int a, int b) {

		if (root == null) {
			return false;
		}

		Queue<TreeNode> queue = new ArrayDeque<>();
		queue.add(root);

		while (!queue.isEmpty()) {

			int size = queue.size();
			boolean aExists = false;
			boolean bExists = false;

			while (size-- > 0) {

				root = queue.remove();
				if (root.val == a) {
					aExists = true;
				}
				if (root.val == b) {
					bExists = true;
				}

				if (root.left != null && root.right != null) {
					if (root.left.val == a && root.right.val == b) {
						return false;
					}
					if (root.left.val == b && root.right.val == a) {
						return false;
					}
				}

				if (root.left != null) {
					queue.add(root.left);
				}
				if (root.right != null) {
					queue.add(root.right);
				}
			}
			if (aExists && bExists) {
				return true;
			} else if (aExists || bExists) {
				return false;
			}
		}
		return false;
	}

}
