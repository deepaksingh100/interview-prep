package me.deepak.interview.tree.binary.search;

import me.deepak.interview.tree.binary.beans.Node;

/*
 * https://www.geeksforgeeks.org/count-bst-subtrees-that-lie-in-given-range/
*/
public class CountBSTSubtreeInRange {

	private CountBSTSubtreeInRange() {
	}

	private static int count = 0;

	public static Integer getCount(Node root, int low, int high) {
		isInRange(root, low, high);
		return count;
	}

	// A recursive function to get count of nodes whose subtree is in range from low
	// to high. This function returns true if nodes in subtree rooted under 'root'
	// are in range.
	private static boolean isInRange(Node root, int low, int high) {

		// base case
		if (root == null) {
			return true;
		}

		// if both left and right subtrees are in range and current Node is also in
		// range, then increment count and return true
		if (isInRange(root.getLeft(), low, high) && isInRange(root.getRight(), low, high) && low <= root.getKey()
				&& root.getKey() <= high) {
			count++;
			return true;
		}

		return false;
	}

}
