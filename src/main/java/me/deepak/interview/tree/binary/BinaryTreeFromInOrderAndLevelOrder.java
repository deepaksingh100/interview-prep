package me.deepak.interview.tree.binary;

import java.util.HashMap;
import java.util.Map;

import me.deepak.interview.tree.binary.beans.Node;

/*
 * https://www.geeksforgeeks.org/construct-tree-inorder-level-order-traversals-set-2/
*/
public class BinaryTreeFromInOrderAndLevelOrder {

	private BinaryTreeFromInOrderAndLevelOrder() {
	}

	public static Node buildTree(int[] inOrder, int[] levelOrder) {
		int start = 0;
		int end = inOrder.length - 1;

		// map of node's key & it's index in inorder[]
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = start; i <= end; i++) {
			map.put(inOrder[i], i);
		}
		return buildTreeFromInOrderAndLevelOrder(inOrder, levelOrder, start, end, map);
	}

	private static Node buildTreeFromInOrderAndLevelOrder(int[] inOrder, int[] levelOrder, int inStart, int inEnd,
			Map<Integer, Integer> map) {

		// Invalid state
		if (inStart > inEnd) {
			return null;
		}

		// first value in level order is always root
		int rootValue = levelOrder[0];
		Node root = new Node(rootValue);

		// get root's index in inorder
		int index = map.get(rootValue);

		// extract root's left subtree from level order traversal
		int[] leftSubtree = extractSubtree(levelOrder, inStart, index - 1, map);

		// extract root's right subtree from level order traversal
		int[] rightSubtree = extractSubtree(levelOrder, index + 1, inEnd, map);

		// build tree recursively
		root.setLeft(buildTreeFromInOrderAndLevelOrder(inOrder, leftSubtree, inStart, index - 1, map));
		root.setRight(buildTreeFromInOrderAndLevelOrder(inOrder, rightSubtree, index + 1, inEnd, map));
		return root;
	}

	// extracts values from given level order from start to end (both inclusive)
	private static int[] extractSubtree(int[] levelOrder, int start, int end, Map<Integer, Integer> map) {

		// length of given subtree
		int subtreeLength = end - start + 1;

		// holds values in given subtree
		int[] subtree = new int[subtreeLength];

		int count = 0;

		// loop on levelOrder[], add values of given subtree to level[]
		for (int i = 0; i < levelOrder.length; i++) {
			int index = map.get(levelOrder[i]);
			if (index >= start && index <= end) {
				subtree[count++] = levelOrder[i];
			}

			// if all values are populates to level[], break
			if (count == subtreeLength) {
				break;
			}
		}
		return subtree;
	}

}
