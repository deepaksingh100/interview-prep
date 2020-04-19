package me.deepak.interview.tree.binary;

import java.util.HashMap;
import java.util.Map;

import me.deepak.interview.tree.binary.beans.Node;

/*
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * https://www.programcreek.com/2014/06/leetcode-construct-binary-tree-from-preorder-and-inorder-traversal-java/
*/
public class BinaryTreeFromInOrderAndPreOrder {

	private BinaryTreeFromInOrderAndPreOrder() {
	}

	public static Node buildTree(int[] inOrder, int[] preOrder) {
		int start = 0;
		int end = inOrder.length - 1;

		// map of node's key & it's index in inorder[]
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = start; i <= end; i++) {
			map.put(inOrder[i], i);
		}
		return buildTreeFromInOrderAndPreOrder(inOrder, start, end, preOrder, start, end, map);
	}

	private static Node buildTreeFromInOrderAndPreOrder(int[] inOrder, int inStart, int inEnd, int[] preOrder,
			int preStart, int preEnd, Map<Integer, Integer> map) {

		// Invalid state
		if (inStart > inEnd || preStart > preEnd) {
			return null;
		}

		// preOrder[preStart] is root's key
		int rootValue = preOrder[preStart];
		Node root = new Node(rootValue);

		// get root's index in inorder
		int index = map.get(rootValue);

		// build tree recursively

		/*
		 * Calculation of start & end indexes of inOrder & preOrder depends on index of
		 * current root's key in inOrder.
		 * 
		 * For left subtree, inStart will not change, inEnd will now be index - 1 (as we
		 * need to visit only the left subtree), preStart will increase by 1 to examine
		 * next root element, preEnd will be preStart + 1 + length of left subtree [preStart
		 * + 1 ... preEnd] - 1, according to inOrder length of left subtree will be index -
		 * inStart, thus preEnd will now be preStart + index - inStart.
		 * 
		 * For right subtree , inStart will now be index + 1 (as we need to visit only
		 * the right subtree), inEnd will not change, preStart will be left subtree's
		 * preEnd + 1, thus preStart will now be preStart + index - inStart + 1, preEnd
		 * will be unchanged.
		 */

		/*
		 * as documented above, for left subtree : inStart = inStart, inEnd = index - 1,
		 * preStart = preStart + 1, preEnd = preStart + index - inStart
		 */
		root.setLeft(buildTreeFromInOrderAndPreOrder(inOrder, inStart, index - 1, preOrder, preStart + 1,
				preStart + index - inStart, map));

		/*
		 * as documented above, for right subtree : inStart = index + 1, inEnd = inEnd,
		 * preStart = preStart + index - inStart + 1, preEnd = preEnd
		 */
		root.setRight(buildTreeFromInOrderAndPreOrder(inOrder, index + 1, inEnd, preOrder,
				preStart + index - inStart + 1, preEnd, map));
		return root;
	}

}
