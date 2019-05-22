package me.deepak.interview.tree.binary;

import java.util.ArrayDeque;
import java.util.Queue;

import me.deepak.interview.tree.binary.beans.Node;

/*
 * https://www.geeksforgeeks.org/write-an-efficient-c-function-to-convert-a-tree-into-its-mirror-tree/
 * https://www.geeksforgeeks.org/create-a-mirror-tree-from-the-given-binary-tree/
*/
public class Mirror {

	private Mirror() {
	}

	public static Node mirror(Node root) {
		if (root == null) {
			return root;
		}

		// do the subtrees
		Node left = mirror(root.getLeft());
		Node right = mirror(root.getRight());

		// swap the left and right pointers
		root.setLeft(right);
		root.setRight(left);

		return root;

	}

	public static Node mirrorIterative(Node root) {
		if (root == null) {
			return null;
		}

		Queue<Node> queue = new ArrayDeque<>();
		queue.add(root);

		// Do level order traversal. While doing BFS, keep swapping left & right
		// children.
		while (!queue.isEmpty()) {
			root = queue.remove();

			// swap left & right children
			root.setLeft(root.getRight());
			root.setRight(root.getLeft());

			// push left & right children
			if (root.getLeft() != null) {
				queue.add(root.getLeft());
			}

			if (root.getRight() != null) {
				queue.add(root.getRight());
			}

		}
		return root;
	}

	public static Node createMirror(Node root) {
		if (root == null) {
			return root;
		}

		// Create new mirror node from original tree node
		Node mirrorRoot = new Node(root.getKey());

		// do the subtrees
		// swap the left and right pointers
		mirrorRoot.setLeft(createMirror(root.getRight()));
		mirrorRoot.setRight(createMirror(root.getLeft()));

		return mirrorRoot;

	}

	public static Node createMirrorIterative(Node root) {
		if (root == null) {
			return null;
		}

		Queue<Node> queue = new ArrayDeque<>();
		queue.add(root);

		Node newRoot = new Node(root.getKey());

		// Do level order traversal. While doing BFS, keep swapping left & right
		// children.
		while (!queue.isEmpty()) {
			root = queue.remove();

			// swap left & right children
			// push left & right children
			if (root.getLeft() != null) {
				newRoot.setRight(new Node(root.getLeft().getKey()));
				queue.add(root.getLeft());
			}

			if (root.getRight() != null) {
				newRoot.setLeft(new Node(root.getRight().getKey()));
				queue.add(root.getRight());
			}

		}
		return newRoot;
	}

}
