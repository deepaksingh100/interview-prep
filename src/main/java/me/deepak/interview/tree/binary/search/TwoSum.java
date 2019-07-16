package me.deepak.interview.tree.binary.search;

import java.util.ArrayDeque;
import java.util.Deque;

import me.deepak.interview.tree.binary.beans.Node;

/*
 * https://www.geeksforgeeks.org/find-a-pair-with-given-sum-in-bst/
 * http://edusagar.com/articles/view/76/find-if-sum-of-two-nodes-is-equal-to-a-given-number-in-bst
*/
public class TwoSum {

	private TwoSum() {
	}

	public static boolean findPair(Node root, int target) {

		Deque<Node> inOrderStack = new ArrayDeque<>();
		Deque<Node> reverseInOrderStack = new ArrayDeque<>();
		Node inOrderCurr = root;
		Node reverseInOrderCurr = root;

		while (!inOrderStack.isEmpty() || !reverseInOrderStack.isEmpty() || inOrderCurr != null
				|| reverseInOrderCurr != null) {
			if (inOrderCurr != null || reverseInOrderCurr != null) {
				if (inOrderCurr != null) {
					inOrderStack.push(inOrderCurr);
					inOrderCurr = inOrderCurr.getLeft();
				}

				if (reverseInOrderCurr != null) {
					reverseInOrderStack.push(reverseInOrderCurr);
					reverseInOrderCurr = reverseInOrderCurr.getRight();
				}
			} else {
				Node inOrderNode = inOrderStack.peek();
				Node reverseInOrderNode = reverseInOrderStack.peek();

				if (inOrderNode == reverseInOrderNode) {
					return false;
				}

				int sum = inOrderNode.getKey() + reverseInOrderNode.getKey();

				if (sum < target) {
					inOrderCurr = inOrderStack.pop();
					inOrderCurr = inOrderCurr.getRight();
				} else if (sum > target) {
					reverseInOrderCurr = reverseInOrderStack.pop();
					reverseInOrderCurr = reverseInOrderCurr.getLeft();
				} else {
					return true;
				}
			}
		}

		return false;
	}

}
