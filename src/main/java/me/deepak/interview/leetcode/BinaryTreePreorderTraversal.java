package me.deepak.interview.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import me.deepak.interview.leetcode.beans.TreeNode;

/*
 * https://leetcode.com/problems/binary-tree-preorder-traversal/
*/
public class BinaryTreePreorderTraversal {

	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> traversal = new ArrayList<>();
		if (root == null) {
			return traversal;
		}

		Deque<TreeNode> stack = new ArrayDeque<>();
		stack.push(root);

		/*
		 * Pop all items one by one. Do following for every popped item
		 * 
		 * a) add it to traversal list
		 * 
		 * b) push its right child
		 * 
		 * c) push its left child
		 * 
		 * Note that right child is pushed first so that left is processed first
		 */
		while (!stack.isEmpty()) {
			root = stack.pop();
			traversal.add(root.val);

			if (root.right != null) {
				stack.push(root.right);
			}
			if (root.left != null) {
				stack.push(root.left);
			}
		}
		return traversal;

	}
}
