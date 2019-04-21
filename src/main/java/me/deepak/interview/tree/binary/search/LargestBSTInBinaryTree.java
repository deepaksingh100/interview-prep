package me.deepak.interview.tree.binary.search;

import me.deepak.interview.tree.binary.beans.Node;

/**
 * 
 * Traverse tree in post order fashion. Left and right nodes return 4 piece of
 * information to root which isBST, size of max BST, min and max in those
 * subtree. If both left and right subtree are BST and this node data is greater
 * than max of left and less than min of right then it returns to above level
 * left size + right size + 1 and new min will be min of left side and new max
 * will be max of right side.
 * 
 * References:
 * 
 * https://youtu.be/4fiDs7CCxkc
 * http://www.geeksforgeeks.org/find-the-largest-subtree-in-a-tree-that-is-also-a-bst/
 * https://leetcode.com/problems/largest-bst-subtree/
 */

public class LargestBSTInBinaryTree {

	private LargestBSTInBinaryTree() {
	}

	public static int largestBST(Node root) {
		MinMax m = largest(root);
		return m.size;
	}

	private static MinMax largest(Node root) {
		if (root == null) {
			return new MinMax();
		}

		// postorder traversal of tree. First visit left and right then
		// use information of left and right to calculate largest BST.
		MinMax leftMinMax = largest(root.getLeft());
		MinMax rightMinMax = largest(root.getRight());

		MinMax currentMinMax = new MinMax();

		// if either of left or right subtree says its not BST or the data
		// of this node is not greater/equal than max of left and less than min of right
		// then subtree with this node as root will not be BST.
		// Return false and max size of left and right subtree to parent
		if (!leftMinMax.isBST || !rightMinMax.isBST
				|| (leftMinMax.max > root.getKey() || rightMinMax.min <= root.getKey())) {
			currentMinMax.isBST = false;
			currentMinMax.size = Math.max(leftMinMax.size, rightMinMax.size);
			return currentMinMax;
		}

		// if we reach this point means subtree with this node as root is BST.
		// Set isBST as true. Then set size as size of left + size of right + 1.
		// Set min and max to be returned to parent.
		currentMinMax.isBST = true;
		currentMinMax.size = leftMinMax.size + rightMinMax.size + 1;

		// if root.left is null then set root.data as min else
		// take min of left side as min
		currentMinMax.min = root.getLeft() != null ? leftMinMax.min : root.getKey();

		// if root.right is null then set root.data as max else
		// take max of right side as max.
		currentMinMax.max = root.getRight() != null ? rightMinMax.max : root.getKey();

		return currentMinMax;
	}
}

/**
 * Object of this class holds information which child passes back to parent
 * node.
 */
class MinMax {
	int min;
	int max;
	boolean isBST;
	int size;

	MinMax() {
		min = Integer.MAX_VALUE;
		max = Integer.MIN_VALUE;
		isBST = true;
		size = 0;
	}
}