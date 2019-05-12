package me.deepak.interview.tree.binary;

import java.util.HashMap;
import java.util.Map;

import me.deepak.interview.tree.binary.beans.Node;

public class BinaryTreeFromInOrderAndPostOrder {

	private BinaryTreeFromInOrderAndPostOrder() {
	}

	public static Node buildTree(int[] inOrder, int[] postOrder, int start, int end) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = start; i <= end; i++) {
			map.put(inOrder[i], i);
		}
		return buildTreeFromInOrderAndPostOrder(inOrder, start, end, postOrder, start, end, map);
	}

	private static Node buildTreeFromInOrderAndPostOrder(int[] inOrder, int inStart, int inEnd, int[] postOrder,
			int postStart, int postEnd, Map<Integer, Integer> map) {
		if (inStart > inEnd || postStart > postEnd) {
			return null;
		}
		int rootValue = postOrder[postEnd];
		Node root = new Node(rootValue);
		int index = map.get(rootValue);
		root.setLeft(buildTreeFromInOrderAndPostOrder(inOrder, inStart, index - 1, postOrder, postStart,
				postEnd + index - inEnd - 1, map));
		root.setRight(buildTreeFromInOrderAndPostOrder(inOrder, index + 1, inEnd, postOrder, postEnd + index - inEnd,
				postEnd - 1, map));
		return root;
	}

}
