package me.deepak.interview.tree.binary;

import me.deepak.interview.tree.binary.beans.Node;

import static me.deepak.interview.tree.binary.Leaf.*;

/*
 * https://www.geeksforgeeks.org/sum-numbers-formed-root-leaf-paths/
*/
public class SumOfNumbersFormedFromRootToLeaf {

	private SumOfNumbersFormedFromRootToLeaf() {
	}

	// Returns sum of all root to leaf paths. The first parameter is
	// root of current subtree, the second parameter is value of the
	// number formed by nodes from root to this node. Call this method as
	// treePathsSum(root, 0);
	public static int treePathsSum(Node root, int val) {

		// base case
		if (root == null) {
			return 0;
		}

		// update val
		val = val * 10 + root.getKey();

		// if current node is leaf, return the current value of val
		if (isLeaf(root)) {
			return val;
		}

		// recur sum of values for left and right subtree
		return treePathsSum(root.getLeft(), val) + treePathsSum(root.getRight(), val);
	}

}
