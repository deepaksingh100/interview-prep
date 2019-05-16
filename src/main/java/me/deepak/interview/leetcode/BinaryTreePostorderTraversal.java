package me.deepak.interview.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import me.deepak.interview.leetcode.beans.TreeNode;

/*
 * https://leetcode.com/problems/binary-tree-postorder-traversal/
*/
public class BinaryTreePostorderTraversal {

	public List<Integer> postorderTraversal(TreeNode root) {
		LinkedList<Integer> traversal = new LinkedList<>();

		if (root == null) {
			return traversal;
		}

		Deque<TreeNode> stack = new ArrayDeque<>();
		stack.push(root);

		/*
		 * Pop all items one by one. Do following for every popped item
		 * 
		 * a) add it head of traversal linked list
		 * 
		 * b) push its left child
		 * 
		 * c) push its right child
		 */
		while (!stack.isEmpty()) {
			root = stack.pop();
			traversal.addFirst(root.val);

			if (root.left != null) {
				stack.push(root.left);
			}

			if (root.right != null) {
				stack.push(root.right);
			}
		}
		return traversal;
	}
}
