package me.deepak.interview.tree.binary;

import java.util.ArrayDeque;
import java.util.Queue;

public class ConnectNodesAtSameLevel {

	private ConnectNodesAtSameLevel() {
	}

	public static void connect(Node root) {

		if (root == null) {
			return;
		}

		Queue<Node> queue = new ArrayDeque<>();
		queue.add(root);

		while (!queue.isEmpty()) {

			int size = queue.size();

			Node prev = null;

			while (size-- > 0) {

				root = queue.remove();

				if (prev != null) {
					prev.nextRight = root;
				}

				if (root.left != null) {
					queue.add(root.left);
				}
				if (root.right != null) {
					queue.add(root.right);
				}

				prev = root;
			}

		}

	}

	class Node {
		int data;
		Node left;
		Node right;
		Node nextRight;

		Node(int data) {
			this.data = data;
		}
	}

}
