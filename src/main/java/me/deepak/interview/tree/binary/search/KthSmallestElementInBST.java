package me.deepak.interview.tree.binary.search;

import java.util.ArrayDeque;
import java.util.Deque;

import me.deepak.interview.leetcode.beans.TreeNode;

/*
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 * https://leetcode.com/articles/kth-smallest-element-in-a-bst/
*/
public class KthSmallestElementInBST {

	public int kthSmallest(TreeNode root, int k) {
		Deque<TreeNode> stack = new ArrayDeque<>();
		while (root != null || !stack.isEmpty()) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();
			if (k-- == 0) {
				return root.val;
			}
			root = root.right;
		}
		return -1;
	}

}
