package me.deepak.interview.tree.binary.search;

import java.util.ArrayDeque;
import java.util.Deque;

import me.deepak.interview.tree.binary.beans.Node;

/*
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 * https://leetcode.com/articles/kth-smallest-element-in-a-bst/
*/
public class KthSmallestElementInBST {

	public int kthSmallest(Node root, int k) {
		Deque<Node> stack = new ArrayDeque<>();
		while (root != null || !stack.isEmpty()) {
			while (root != null) {
				stack.push(root);
				root = root.getLeft();
			}
			root = stack.pop();
			if (k-- == 0) {
				return root.getKey();
			}
			root = root.getRight();
		}
		return -1;
	}

}
