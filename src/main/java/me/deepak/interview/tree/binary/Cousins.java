package me.deepak.interview.tree.binary;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import me.deepak.interview.tree.binary.beans.Node;

/*
 * https://www.geeksforgeeks.org/print-cousins-of-a-given-node-in-binary-tree-single-traversal/
*/
public class Cousins {

	private Cousins() {
	}

	public static List<Integer> getCousins(Node root, Node target) {

		List<Integer> cousins = new ArrayList<>();

		// if the given node is the root itself, then no nodes would be returned
		if (root == null || root == target) {
			return cousins;
		}

		Queue<Node> queue = new ArrayDeque<>();
		queue.add(root);
		boolean found = false;

		// the following loop runs until found is not true, or queue is not empty. if
		// found has become true => we have found the level in which the node is present
		// and the present queue will contain all the cousins of that node
		while (!queue.isEmpty() && !found) {

			int size = queue.size();
			while (size-- > 0) {

				root = queue.remove();

				// if current node's left or right same as the node to find, then make found =
				// true, and don't push any of them into the queue, as we don't have to print
				// the siblings
				if ((root.getLeft() == target || root.getRight() == target)) {
					found = true;
				} else {
					if (root.getLeft() != null) {
						queue.add(root.getLeft());
					}
					if (root.getRight() != null) {
						queue.add(root.getRight());
					}
				}
			}
		}
		return cousins;
	}

}
