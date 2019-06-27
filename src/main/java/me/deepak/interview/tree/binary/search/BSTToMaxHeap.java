package me.deepak.interview.tree.binary.search;

import java.util.ArrayList;
import java.util.List;

import me.deepak.interview.tree.binary.beans.Node;

/*
 * https://www.geeksforgeeks.org/convert-bst-to-max-heap/
*/
public class BSTToMaxHeap {

	private BSTToMaxHeap() {
	}

	public static void convert(Node root) {
		if (root == null) {
			return;
		}

		List<Integer> inOrder = new ArrayList<>();
		populateInorder(root, inOrder);
		convert(root, inOrder);

	}

	private static void populateInorder(Node root, List<Integer> inOrder) {
		if (root != null) {
			populateInorder(root.getLeft(), inOrder);
			inOrder.add(root.getKey());
			populateInorder(root.getRight(), inOrder);
		}
	}

	private static int index = 0;

	private static void convert(Node root, List<Integer> inOrder) {
		if (root == null) {
			return;
		}

		convert(root.getLeft(), inOrder);
		convert(root.getRight(), inOrder);
		root.setKey(inOrder.get(index++));

	}

}
