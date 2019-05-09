package me.deepak.interview.tree.binary.traversals;

import static me.deepak.interview.tree.binary.Height.getHeight;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import me.deepak.interview.tree.binary.beans.Node;

/*
 * https://www.geeksforgeeks.org/level-order-tree-traversal/
 * https://www.geeksforgeeks.org/reverse-level-order-traversal/
*/
public class LevelOrder {

	private LevelOrder() {
	}

	// O(n^2)
	public static void levelOrder(Node root) {
		int height = getHeight(root);

		// call level order from top to bottom
		for (int i = 1; i <= height; i++) {
			levelOrder(root, i);
		}
	}

	// O(n^2)
	public static void reverseLevelOrder(Node root) {
		int height = getHeight(root);

		// call level order from bottom to top
		for (int i = height; i >= 1; i--) {
			levelOrder(root, i);
		}
	}

	private static void levelOrder(Node root, int level) {

		// base case
		if (root == null) {
			return;
		}

		// if we are at given level, print values
		if (level == 1) {
			System.out.println(root.getKey() + " ");
		} else {

			// go to left & right with level - 1
			levelOrder(root.getLeft(), level - 1);
			levelOrder(root.getRight(), level - 1);
		}
	}

	public static void levelOrderIterative(Node root) {

		// base case
		if (root == null) {
			return;
		}

		Queue<Node> queue = new ArrayDeque<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			int size = queue.size();

			// print current level nodes in one line
			while (size-- > 0) {
				root = queue.remove();
				System.out.print(root.getKey() + " ");

				// enqueue left child
				if (root.getLeft() != null) {
					queue.add(root.getLeft());
				}

				// enqueue right child
				if (root.getRight() != null) {
					queue.add(root.getRight());
				}
			}
			System.out.println();
		}
	}

	public static void reverseLevelOrderIterative(Node root) {

		// hold final traversal level by level
		LinkedList<List<Integer>> traversal = new LinkedList<>();
		if (root == null) {
			return;
		}
		Queue<Node> queue = new ArrayDeque<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> levelTraversal = new ArrayList<>();
			while (size-- > 0) {
				root = queue.remove();
				levelTraversal.add(root.getKey());
				if (root.getLeft() != null) {
					queue.add(root.getLeft());
				}
				if (root.getRight() != null) {
					queue.add(root.getRight());
				}
			}

			// this works as stack, latest level at front
			traversal.addFirst(levelTraversal);
		}

		// print one level per line
		for (List<Integer> list : traversal) {
			for (int i : list) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}

}
