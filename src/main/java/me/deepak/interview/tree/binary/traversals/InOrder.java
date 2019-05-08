package me.deepak.interview.tree.binary.traversals;

import java.util.ArrayDeque;
import java.util.Deque;

import me.deepak.interview.tree.binary.beans.Node;

/*
 * https://github.com/mission-peace/interview/blob/master/src/com/interview/tree/TreeTraversals.java
*/
public class InOrder {

	private InOrder() {
	}

	/*
	 * https://www.geeksforgeeks.org/tree-traversals-inorder-preorder-and-postorder/
	 * https://youtu.be/gm8DUJJhmY4
	 */
	public static void inOrder(Node root) {
		if (root != null) {
			inOrder(root.getLeft());
			System.out.print(root.getKey() + " ");
			inOrder(root.getRight());
		}
	}

	/*
	 * https://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion/
	 * https://youtu.be/nzmtCFNae9k
	 */
	public static void inOrderIterative(Node root) {
		if (root == null) {
			return;
		}
		Deque<Node> stack = new ArrayDeque<>();
		while (root != null || !stack.isEmpty()) {

			// reach the left most Node from root
			while (root != null) {
				stack.push(root);
				root = root.getLeft();
			}
			root = stack.pop();
			System.out.print(root.getKey() + " ");

			// we have visited the node and its left subtree. Now, it's right subtree's turn
			root = root.getRight();

		}
	}

}
