package me.deepak.interview.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

import me.deepak.interview.leetcode.beans.TreeNode;

/*
 * https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
 * https://leetcode.com/articles/two-sum-iv/
 * https://www.geeksforgeeks.org/find-a-pair-with-given-sum-in-bst/
 * http://edusagar.com/articles/view/76/find-if-sum-of-two-nodes-is-equal-to-a-given-number-in-bst
*/
public class TwoSum4 {

	public boolean findTarget(TreeNode root, int target) {

		Deque<TreeNode> inOrderStack = new ArrayDeque<>();
		Deque<TreeNode> reverseInOrderStack = new ArrayDeque<>();
		TreeNode inOrderCurr = root;
		TreeNode reverseInOrderCurr = root;

		while (!inOrderStack.isEmpty() || !reverseInOrderStack.isEmpty() || inOrderCurr != null
				|| reverseInOrderCurr != null) {
			if (inOrderCurr != null || reverseInOrderCurr != null) {
				if (inOrderCurr != null) {
					inOrderStack.push(inOrderCurr);
					inOrderCurr = inOrderCurr.left;
				}

				if (reverseInOrderCurr != null) {
					reverseInOrderStack.push(reverseInOrderCurr);
					reverseInOrderCurr = reverseInOrderCurr.right;
				}
			} else {
				TreeNode inOrderNode = inOrderStack.peek();
				TreeNode reverseInOrderNode = reverseInOrderStack.peek();

				if (inOrderNode == reverseInOrderNode) {
					return false;
				}

				int sum = inOrderNode.val + reverseInOrderNode.val;

				if (sum < target) {
					inOrderCurr = inOrderStack.pop();
					inOrderCurr = inOrderCurr.right;
				} else if (sum > target) {
					reverseInOrderCurr = reverseInOrderStack.pop();
					reverseInOrderCurr = reverseInOrderCurr.left;
				} else {
					return true;
				}
			}
		}

		return false;
	}
}
