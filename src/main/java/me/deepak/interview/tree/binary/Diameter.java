package me.deepak.interview.tree.binary;

import static me.deepak.interview.tree.binary.Height.getHeight;

import me.deepak.interview.tree.binary.beans.Node;

/*
 * https://www.geeksforgeeks.org/diameter-of-a-binary-tree/
 */
public class Diameter {

	// time complexity is O(n^2), due to repeated calling of getHeight()
	public int getDiameter(Node root) {

		// base case if tree is empty
		if (root == null) {
			return 0;
		}

		// get the height of left and right sub trees
		int leftHeight = getHeight(root.getLeft());
		int rightHeight = getHeight(root.getRight());

		// get the diameter of left and right subtrees
		int leftDiameter = getDiameter(root.getLeft());
		int rightDiameter = getDiameter(root.getRight());

		/*
		 * return max of following three
		 * 
		 * 1) Diameter of left subtree
		 * 
		 * 2) Diameter of right subtree
		 * 
		 * 3) Height of left subtree + height of right subtree + 1
		 */
		return Math.max(leftHeight + rightHeight + 1, Math.max(leftDiameter, rightDiameter));
	}

	class Height {
		int h = 0;
	}

	// time complexity is O(n)
	public int getDiameterOptimized(Node root, Height height) {

		// base case if tree is empty
		if (root == null) {
			return 0;
		}

		// height of left subtree
		Height leftHeight = new Height();

		// height of right subtree
		Height rightHeight = new Height();

		// get the diameter of left and right subtrees
		int leftDiameter = getDiameterOptimized(root.getLeft(), leftHeight);
		int rightDiameter = getDiameterOptimized(root.getRight(), rightHeight);

		// set height of current node
		height.h = Math.max(leftHeight.h, rightHeight.h) + 1;

		/*
		 * return max of following three
		 * 
		 * 1) Diameter of left subtree
		 * 
		 * 2) Diameter of right subtree
		 * 
		 * 3) Height of left subtree + height of right subtree + 1
		 */
		return Math.max(leftHeight.h + rightHeight.h + 1, Math.max(leftDiameter, rightDiameter));
	}
}
