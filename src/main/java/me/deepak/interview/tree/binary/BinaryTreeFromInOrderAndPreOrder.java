package me.deepak.interview.tree.binary;

import java.util.HashMap;
import java.util.Map;

import me.deepak.interview.tree.binary.beans.Node;

public class BinaryTreeFromInOrderAndPreOrder {

	private BinaryTreeFromInOrderAndPreOrder() {
	}

	public static Node buildTree(int[] inOrder, int[] preOrder, int start, int end) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = start; i <= end; i++) {
			map.put(inOrder[i], i);
		}
		return buildTreeFromInOrderAndPreOrder(inOrder, start, end, preOrder, start, end, map);
	}

	public static Node buildTreeFromInOrderAndPreOrder(int[] inOrder, int inStart, int inEnd, int[] preOrder,
			int preStart, int preEnd, Map<Integer, Integer> map) {
		if (inStart > inEnd || preStart > preEnd) {
			return null;
		}
		int rootValue = preOrder[preStart];
		Node root = new Node(rootValue);
		int index = map.get(rootValue);
		root.setLeft(buildTreeFromInOrderAndPreOrder(inOrder, inStart, index - 1, preOrder, preStart + 1,
				preEnd + index - inEnd, map));
		root.setRight(buildTreeFromInOrderAndPreOrder(inOrder, index + 1, inEnd, preOrder, preEnd + index + 1 - inEnd,
				preEnd, map));
		return root;
	}

}
