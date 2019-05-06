package me.deepak.interview.tree.binary;

import java.util.HashMap;
import java.util.Map;

import me.deepak.interview.tree.binary.beans.Node;

public class BinaryTreeFromInOrderAndLevelOrder {

	private BinaryTreeFromInOrderAndLevelOrder() {
	}

	public static Node buildTree(int[] inOrder, int[] levelOrder, int start, int end) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = start; i <= end; i++) {
			map.put(inOrder[i], i);
		}
		return buildTreeFromInOrderAndLevelOrder(inOrder, levelOrder, start, end, map);
	}

	public static Node buildTreeFromInOrderAndLevelOrder(int[] inOrder, int[] levelOrder, int inStart, int inEnd,
			Map<Integer, Integer> map) {
		if (inStart > inEnd) {
			return null;
		}
		int rootValue = levelOrder[0];
		Node root = new Node(rootValue);
		int index = map.get(rootValue);
		int[] leftLevel = extractLevel(levelOrder, inStart, index - 1, map);
		int[] rightLevel = extractLevel(levelOrder, index + 1, inEnd, map);
		root.setLeft(buildTreeFromInOrderAndLevelOrder(inOrder, leftLevel, inStart, index - 1, map));
		root.setRight(buildTreeFromInOrderAndLevelOrder(inOrder, rightLevel, index + 1, inEnd, map));
		return root;
	}

	private static int[] extractLevel(int[] levelOrder, int start, int end, Map<Integer, Integer> map) {
		int[] level = new int[end - start + 1];
		int count = 0;
		for (int i = 0; i < levelOrder.length; i++) {
			int index = map.get(levelOrder[i]);
			if (index >= start && index <= end) {
				level[count++] = levelOrder[i];
			}
		}
		return level;
	}

}
