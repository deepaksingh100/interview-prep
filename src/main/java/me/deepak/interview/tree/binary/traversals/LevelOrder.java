package me.deepak.interview.tree.binary.traversals;

import static me.deepak.interview.tree.binary.Height.getHeight;

import java.util.ArrayDeque;
import java.util.Queue;

import me.deepak.interview.tree.binary.beans.Node;

public class LevelOrder {

	private LevelOrder() {
	}

	public static void levelOrder(Node root) {
		int height = getHeight(root);
		for (int i = 1; i <= height; i++) {
			levelOrder(root, i);
		}
	}

	public static void reverseLevelOrder(Node root) {
		int height = getHeight(root);
		for (int i = height; i >= 1; i--) {
			levelOrder(root, i);
		}
	}

	private static void levelOrder(Node root, int level) {
		if (root == null) {
			return;
		}
		if (level == 1) {
			System.out.println(root.getKey() + " ");
		} else {
			levelOrder(root.getLeft(), level - 1);
			levelOrder(root.getRight(), level - 1);
		}
	}

	public static void levelOrderIterative(Node root) {
		if (root == null) {
			return;
		}
		Queue<Node> queue = new ArrayDeque<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			root = queue.remove();
			System.out.print(root.getKey() + " ");
			if (root.getLeft() != null) {
				queue.add(root.getLeft());
			}
			if (root.getRight() != null) {
				queue.add(root.getRight());
			}
		}
	}

	public static void reverseLevelOrderIterative(Node root) {
		if (root == null) {
			return;
		}
		Queue<Node> queue = new ArrayDeque<>();
		ArrayDeque<Node> stack = new ArrayDeque<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			root = queue.remove();
			stack.push(root);
			if (root.getRight() != null) {
				queue.add(root.getRight());
			}
			if (root.getLeft() != null) {
				queue.add(root.getLeft());
			}
		}
		while (!stack.isEmpty()) {
			System.out.print(stack.pop().getKey() + " ");
		}
	}

}
