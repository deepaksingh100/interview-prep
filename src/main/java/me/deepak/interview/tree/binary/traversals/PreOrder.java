package me.deepak.interview.tree.binary.traversals;

import java.util.ArrayDeque;
import java.util.Deque;

import me.deepak.interview.tree.binary.beans.Node;

/*
 * https://github.com/mission-peace/interview/blob/master/src/com/interview/tree/TreeTraversals.java
*/
public class PreOrder {

	private PreOrder() {
	}

	/*
	 * https://www.geeksforgeeks.org/tree-traversals-inorder-preorder-and-postorder/
	 * https://youtu.be/gm8DUJJhmY4
	 */
	public static void preOrder(Node root) {
		if (root != null) {
			System.out.print(root.getKey() + " ");
			preOrder(root.getLeft());
			preOrder(root.getRight());
		}
	}

	/*
	 * https://www.geeksforgeeks.org/iterative-preorder-traversal/
	 * https://youtu.be/elQcrJrfObg
	 */
	public static void preOrderIterative(Node root) {
		if (root == null) {
			return;
		}
		Deque<Node> stack = new ArrayDeque<>();
		stack.push(root);

		/*
		 * Pop all items one by one. Do following for every popped item
		 * 
		 * a) print it
		 * 
		 * b) push its right child
		 * 
		 * c) push its left child
		 * 
		 * Note that right child is pushed first so that left is processed first
		 */
		while (!stack.isEmpty()) {
			root = stack.pop();
			System.out.print(root.getKey() + " ");
			if (root.getRight() != null) {
				stack.push(root.getRight());
			}
			if (root.getLeft() != null) {
				stack.push(root.getLeft());
			}
		}
	}

}
