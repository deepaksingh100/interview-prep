package me.deepak.interview.tree.binary.traversals;

import java.util.ArrayDeque;

import me.deepak.interview.tree.binary.beans.Node;

public class PreOrder {

	private PreOrder() {
	}

	public static void preOrder(Node root) {
		if (root != null) {
			System.out.print(root.getKey() + " ");
			preOrder(root.getLeft());
			preOrder(root.getRight());
		}
	}

	public static void preOrderIterative(Node root) {
		if (root == null) {
			return;
		}
		ArrayDeque<Node> stack = new ArrayDeque<>();
		stack.push(root);
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
