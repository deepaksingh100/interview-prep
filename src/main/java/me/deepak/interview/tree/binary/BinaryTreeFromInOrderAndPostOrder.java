package me.deepak.interview.tree.binary;

import java.util.HashMap;
import java.util.Map;

import me.deepak.interview.tree.binary.beans.Node;

/*
 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 * https://www.programcreek.com/2013/01/construct-binary-tree-from-inorder-and-postorder-traversal/
*/
public class BinaryTreeFromInOrderAndPostOrder {

	private BinaryTreeFromInOrderAndPostOrder() {
	}

	public static Node buildTree(int[] inOrder, int[] postOrder) {
		int start = 0;
		int end = inOrder.length - 1;

		// map of node's key & it's index in inorder[]
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = start; i <= end; i++) {
			map.put(inOrder[i], i);
		}
		return buildTreeFromInOrderAndPostOrder(inOrder, start, end, postOrder, start, end, map);
	}

	private static Node buildTreeFromInOrderAndPostOrder(int[] inOrder, int inStart, int inEnd, int[] postOrder,
			int postStart, int postEnd, Map<Integer, Integer> map) {

		// Invalid state
		if (inStart > inEnd || postStart > postEnd) {
			return null;
		}

		// postOrder[postEnd] is root's key
		int rootValue = postOrder[postEnd];
		Node root = new Node(rootValue);

		// get root's index in inorder
		int index = map.get(rootValue);

		// build tree recursively

		/*
		 * Calculation of start & end indexes of inOrder & postOrder depends on index of
		 * current root's key in inOrder.
		 * 
		 * For left subtree, inStart will not change, inEnd will now be index - 1 (as we
		 * need to visit only the left subtree), postStart will not change, postEnd will
		 * be postStart + length of left subtree - 1 [postStart ... postEnd], according
		 * to inOrder length of left subtree will be index - inStart, thus postEnd will
		 * now be postStart + index - inStart - 1
		 * 
		 * For right subtree , inStart will now be index + 1 (as we need to visit only
		 * the right subtree), inEnd will not change, postStart will be left subtree's
		 * postEnd + 1, thus postStart will now be postStart + index - inStart, postEnd
		 * will decrease by 1 to examine next root element.
		 */

		/*
		 * as documented above, for left subtree : inStart = inStart, inEnd = index - 1,
		 * postStart = postStart, postEnd = postStart + index - inStart - 1
		 */

		root.setLeft(buildTreeFromInOrderAndPostOrder(inOrder, inStart, index - 1, postOrder, postStart,
				postStart + index - inStart - 1, map));

		/*
		 * as documented above, for right subtree : inStart = index + 1, inEnd = inEnd,
		 * postStart = postStart + index - inStart, postEnd = postEnd - 1
		 */
		root.setRight(buildTreeFromInOrderAndPostOrder(inOrder, index + 1, inEnd, postOrder,
				postStart + index - inStart, postEnd - 1, map));
		return root;
	}

}
