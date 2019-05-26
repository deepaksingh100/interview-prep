package me.deepak.interview.leetcode;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

import me.deepak.interview.leetcode.beans.TreeNode;

/*
 * https://leetcode.com/problems/maximum-width-of-binary-tree/
 * https://leetcode.com/problems/maximum-width-of-binary-tree/discuss/106653/Java-One-Queue-Solution-with-HashMap
*/
public class MaximumWidthOfBinaryTree {

	public int widthOfBinaryTree(TreeNode root) {
		if (root == null) {
			return 0;
		}
		Queue<TreeNode> queue = new ArrayDeque<>();

		// map of Node & it's proposed index in array representation
		Map<TreeNode, Integer> map = new HashMap<>();

		// queue for storing current level nodes
		queue.add(root);

		// put root with index 1 in map
		map.put(root, 1);

		int currentWidth = 0;
		int maxWidth = 0;

		while (!queue.isEmpty()) {
			int size = queue.size();
			int start = 0;
			int end = 0;
			for (int i = 0; i < size; i++) {

				TreeNode node = queue.remove();

				if (i == 0) {

					// first node, get start
					start = map.get(node);
				}

				if (i == size - 1) {

					// last node, get end
					end = map.get(node);
				}

				if (node.left != null) {

					// index of left child is 2 * parent index
					map.put(node.left, map.get(node) * 2);
					queue.add(node.left);
				}

				if (node.right != null) {

					// index of right child is 2 * parent index + 1
					map.put(node.right, map.get(node) * 2 + 1);
					queue.add(node.right);
				}
			}

			// calculate current width & eventually max width
			currentWidth = end - start + 1;
			maxWidth = Math.max(currentWidth, maxWidth);
		}
		return maxWidth;
	}

}
