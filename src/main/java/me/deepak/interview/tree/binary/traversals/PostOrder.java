package me.deepak.interview.tree.binary.traversals;

import java.util.ArrayDeque;

import me.deepak.interview.tree.binary.beans.Node;

public class PostOrder {

	private PostOrder() {
	}

	public static void postOrder(Node root) {
		if (root != null) {
			postOrder(root.getLeft());
			postOrder(root.getRight());
			System.out.print(root.getKey() + " ");
		}
	}

	public static void postOrderIterative(Node root) {
		if (root == null) {
			return;
		}
		ArrayDeque<Node> stack1 = new ArrayDeque<>();
		ArrayDeque<Node> stack2 = new ArrayDeque<>();
		stack1.push(root);
		while (!stack1.isEmpty()) {
			root = stack1.pop();
			stack2.push(root);
			if (root.getLeft() != null) {
				stack1.push(root.getLeft());
			}
			if (root.getRight() != null) {
				stack1.push(root.getRight());
			}
		}
		while (!stack2.isEmpty()) {
			System.out.print(stack2.pop().getKey() + " ");
		}
	}

	public static void postOrderWithOneStack(Node root) {
		Node current = root;
		ArrayDeque<Node> stack = new ArrayDeque<>();
		while (current != null || !stack.isEmpty()) {
			if (current != null) {
				stack.push(current);
				current = current.getLeft();
			} else {
				Node temp = stack.peek().getRight();
				if (temp == null) {
					temp = stack.pop();
					System.out.print(temp.getKey() + " ");
					while (!stack.isEmpty() && temp == stack.peek().getRight()) {
						System.out.print(stack.pop().getKey() + " ");
					}
				} else {
					current = temp;
				}
			}
		}
	}

}
