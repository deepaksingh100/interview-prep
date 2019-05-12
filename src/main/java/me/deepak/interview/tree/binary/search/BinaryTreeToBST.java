package me.deepak.interview.tree.binary.search;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import me.deepak.interview.tree.binary.beans.Node;

/*
 * https://www.geeksforgeeks.org/binary-tree-to-binary-search-tree-conversion/
*/
public class BinaryTreeToBST {

	private BinaryTreeToBST() {
	}

	public static Node convert(Node root) {
		LinkedList<Integer> inOrder = new LinkedList<>();
		treeToListInOrder(root, inOrder);
		Collections.sort(inOrder);
		listToTreeInOrder(root, inOrder);
		return root;
	}

	private static void treeToListInOrder(Node root, List<Integer> inOrder) {
		if (root != null) {
			treeToListInOrder(root.getLeft(), inOrder);
			inOrder.add(root.getKey());
			treeToListInOrder(root.getRight(), inOrder);
		}
	}

	private static void listToTreeInOrder(Node root, LinkedList<Integer> inOrder) {
		if (root != null) {
			listToTreeInOrder(root.getLeft(), inOrder);
			root.setKey(inOrder.removeFirst());
			listToTreeInOrder(root.getRight(), inOrder);
		}
	}

}
