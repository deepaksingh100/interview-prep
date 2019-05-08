package me.deepak.interview.tree.binary.traversals;

import java.util.ArrayDeque;
import java.util.Deque;

import me.deepak.interview.tree.binary.beans.Node;

/*
 * https://github.com/mission-peace/interview/blob/master/src/com/interview/tree/TreeTraversals.java
*/
public class PostOrder {

	private PostOrder() {
	}

	/*
	 * https://www.geeksforgeeks.org/tree-traversals-inorder-preorder-and-postorder/
	 * https://youtu.be/gm8DUJJhmY4
	 */
	public static void postOrder(Node root) {
		if (root != null) {
			postOrder(root.getLeft());
			postOrder(root.getRight());
			System.out.print(root.getKey() + " ");
		}
	}

	/*
	 * https://www.geeksforgeeks.org/iterative-postorder-traversal/
	 * https://youtu.be/qT65HltK2uE
	 */
	public static void postOrderIterative(Node root) {
		if (root == null) {
			return;
		}
		Deque<Node> stack1 = new ArrayDeque<>();
		Deque<Node> stack2 = new ArrayDeque<>();

		// push root to first stack
		stack1.push(root);

		// run while first stack is not empty
		while (!stack1.isEmpty()) {

			// pop an item from stack1 and push it to stack2
			root = stack1.pop();
			stack2.push(root);

			// push left and right children of removed item to stack1
			if (root.getLeft() != null) {
				stack1.push(root.getLeft());
			}
			if (root.getRight() != null) {
				stack1.push(root.getRight());
			}
		}

		// print all elements of stack2
		while (!stack2.isEmpty()) {
			System.out.print(stack2.pop().getKey() + " ");
		}
	}

	/*
	 * https://www.geeksforgeeks.org/iterative-postorder-traversal-using-stack/
	 * https://youtu.be/xLQKdq0Ffjg
	 */
	public static void postOrderWithOneStack(Node root) {
		Deque<Node> stack = new ArrayDeque<>();
		while (root != null || !stack.isEmpty()) {

			// if current node is not null, push it to stack & go to it's left
			if (root != null) {
				stack.push(root);
				root = root.getLeft();
			} else {
				Node temp = stack.peek().getRight();
				if (temp == null) {

					// if right is null (& left is already null), then visit this node
					temp = stack.pop();
					System.out.print(temp.getKey() + " ");

					// check if temp is right child of top element in stack
					while (!stack.isEmpty() && temp == stack.peek().getRight()) {

						// update temp
						temp = stack.pop();
						System.out.print(temp.getKey() + " ");
					}
				} else {
					root = temp;
				}
			}
		}
	}

}
