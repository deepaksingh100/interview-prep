package me.deepak.interview.tree.binary.traversals;

import java.util.ArrayDeque;

import me.deepak.interview.tree.binary.beans.Node;

public class InOrder {

	private InOrder() {
	}

	public static void inOrder(Node root) {
		if (root != null) {
			inOrder(root.getLeft());
			System.out.print(root.getKey() + " ");
			inOrder(root.getRight());
		}
	}

	public static void inOrderIterative(Node root) {
		if (root == null) {
			return;
		}
		ArrayDeque<Node> stack = new ArrayDeque<>();
		while (true) {
			if (root != null) {
				stack.push(root);
				root = root.getLeft();
			} else {
				if (stack.isEmpty()) {
					return;
				}
				root = stack.pop();
				System.out.print(root.getKey() + " ");
				root = root.getRight();
			}
		}
	}

}
