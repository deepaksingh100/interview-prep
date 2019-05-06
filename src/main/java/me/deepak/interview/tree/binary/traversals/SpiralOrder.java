package me.deepak.interview.tree.binary.traversals;

import static me.deepak.interview.tree.binary.Height.getHeight;

import java.util.ArrayDeque;

import me.deepak.interview.tree.binary.beans.Node;

public class SpiralOrder {

	private SpiralOrder() {
	}

	public static void spiralOrder(Node root) {
		int height = getHeight(root);
		boolean isLeftToRightTraversal = true;
		for (int i = 1; i <= height; i++) {
			spiralOrder(root, i, isLeftToRightTraversal);
			isLeftToRightTraversal = !isLeftToRightTraversal;
		}
	}

	private static void spiralOrder(Node root, int level, boolean isLeftToRightTraversal) {
		if (root == null) {
			return;
		}
		if (level == 1) {
			System.out.println(root.getKey() + " ");
		} else {
			if (isLeftToRightTraversal) {
				spiralOrder(root.getLeft(), level - 1, isLeftToRightTraversal);
				spiralOrder(root.getRight(), level - 1, isLeftToRightTraversal);
			} else {
				spiralOrder(root.getRight(), level - 1, isLeftToRightTraversal);
				spiralOrder(root.getLeft(), level - 1, isLeftToRightTraversal);
			}
		}
	}

	public static void spiralOrderIterative(Node root) { // first level left to right and so on
		if (root == null) {
			return;
		}
		ArrayDeque<Node> deque = new ArrayDeque<>();
		deque.add(root);
		int level = 0;
		while (!deque.isEmpty()) {
			int size = deque.size();
			if ((level & 1) == 0) {
				while (size-- > 0) {
					root = deque.removeFirst();
					System.out.print(root.getKey() + " ");
					if (root.getLeft() != null) {
						deque.addLast(root.getLeft());
					}
					if (root.getRight() != null) {
						deque.addLast(root.getRight());
					}
				}
			} else {
				while (size-- > 0) {
					root = deque.removeLast();
					System.out.print(root.getKey() + " ");
					if (root.getRight() != null) {
						deque.addFirst(root.getRight());
					}
					if (root.getLeft() != null) {
						deque.addFirst(root.getLeft());
					}
				}
			}
			level++;
		}
	}

}
