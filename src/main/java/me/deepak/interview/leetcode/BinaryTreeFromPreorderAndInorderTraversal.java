package me.deepak.interview.leetcode;

import java.util.HashMap;
import java.util.Map;

import me.deepak.interview.leetcode.beans.TreeNode;

/*
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
*/

public class BinaryTreeFromPreorderAndInorderTraversal {

	public TreeNode buildTree(int[] preOrder, int[] inOrder) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < inOrder.length; i++) {
			map.put(inOrder[i], i);
		}
		return buildTree(inOrder, 0, inOrder.length - 1, preOrder, 0, preOrder.length - 1, map);
	}

	private TreeNode buildTree(int[] inOrder, int inStart, int inEnd, int[] preOrder, int preStart, int preEnd,
			Map<Integer, Integer> map) {
		if (inStart > inEnd || preStart > preEnd) {
			return null;
		}
		int rootValue = preOrder[preStart];
		TreeNode root = new TreeNode(rootValue);
		int index = map.get(rootValue);
		root.left = buildTree(inOrder, inStart, index - 1, preOrder, preStart + 1, preEnd + index - inEnd, map);
		root.right = buildTree(inOrder, index + 1, inEnd, preOrder, preEnd + index + 1 - inEnd, preEnd, map);
		return root;
	}

}
