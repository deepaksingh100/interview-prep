package me.deepak.interview.tree.binary;

import static me.deepak.interview.tree.binary.Height.getHeight;

import me.deepak.interview.tree.binary.beans.Node;

/*
 * https://www.geeksforgeeks.org/how-to-determine-if-a-binary-tree-is-balanced/
*/
public class BalancedTree {

	public boolean isBalanced(Node root) {

		// base case if tree is empty
		if (root == null) {
			return true;
		}

		// get the height of left and right sub trees
		int leftHeight = getHeight(root.getLeft());
		int rightHeight = getHeight(root.getRight());

		// get isBalanced for left and right subtrees
		boolean isLeftBalanced = isBalanced(root.getLeft());
		boolean isRightBalanced = isBalanced(root.getRight());

		/*
		 * return logical AND of following three
		 * 
		 * 1) isBalanced for left subtree
		 * 
		 * 2) isBalanced for right subtree
		 * 
		 * 3) difference of height of left subtree and height of right subtree must be
		 * less than or equals to 1
		 */
		return Math.abs(leftHeight - rightHeight) <= 1 && isLeftBalanced && isRightBalanced;
	}

	private static class Height {
		int h = 0;
	}

	public boolean isBalancedOptimized(Node root, Height height) {

		// base case if tree is empty
		if (root == null) {
			return true;
		}

		// height of left subtree
		Height leftHeight = new Height();

		// height of right subtree
		Height rightHeight = new Height();

		// get isBalanced for left and right subtrees
		boolean isLeftBalanced = isBalancedOptimized(root.getLeft(), leftHeight);
		boolean isRightBalanced = isBalancedOptimized(root.getRight(), rightHeight);

		// set height of current node
		height.h = Math.max(leftHeight.h, rightHeight.h) + 1;

		/*
		 * return logical AND of following three
		 * 
		 * 1) isBalanced for left subtree
		 * 
		 * 2) isBalanced for right subtree
		 * 
		 * 3) difference of height of left subtree and height of right subtree must be
		 * less than or equals to 1
		 */
		return Math.abs(leftHeight.h - rightHeight.h) <= 1 && isLeftBalanced && isRightBalanced;
	}

}
