package me.deepak.interview.leetcode;

import java.util.HashMap;
import java.util.Map;

import me.deepak.interview.leetcode.beans.TreeNode;

/*
 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
*/

public class BinaryTreeFromInorderAndPostorderTraversal {

	public TreeNode buildTree(int[] inOrder, int[] postOrder) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < inOrder.length; i++) {
			map.put(inOrder[i], i);
		}
		return buildTree(inOrder, 0, inOrder.length - 1, postOrder, 0, postOrder.length - 1, map);
	}

	private TreeNode buildTree(int[] inOrder, int inStart, int inEnd, int[] postOrder, int postStart, int postEnd,
			Map<Integer, Integer> map) {
		if (inStart > inEnd || postStart > postEnd) {
			return null;
		}
		int rootValue = postOrder[postEnd];
		TreeNode root = new TreeNode(rootValue);
		int index = map.get(rootValue);
		root.left = buildTree(inOrder, inStart, index - 1, postOrder, postStart, postStart + index - inStart - 1, map);
		root.right = buildTree(inOrder, index + 1, inEnd, postOrder, postStart + index - inStart, postEnd - 1, map);
		return root;
	}

}
