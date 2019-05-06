package me.deepak.interview.tree.binary;

import java.util.ArrayList;
import java.util.List;

import me.deepak.interview.tree.binary.beans.Node;

public class RootToLeafPaths {

	private RootToLeafPaths() {
	}

	/*
	 * https://www.ideserve.co.in/learn/print-all-root-to-leaf-paths-of-a-binary-
	 * tree
	 * 
	 * https://www.geeksforgeeks.org/given-a-binary-tree-print-all-root-to-leaf-
	 * paths/
	 */
	public static void findRootToLeafPaths(Node root, List<Integer> currentPath, List<List<Integer>> paths) {
		if (root == null) {
			return;
		}

		// add root data to the path.
		currentPath.add(root.getKey());

		// if root is a leaf, add the path to paths and return.
		if (root.getLeft() == null && root.getRight() == null) {
			paths.add(currentPath);
			return;
		}

		// recursively traverse the left & right subtree.
		findRootToLeafPaths(root.getLeft(), new ArrayList<Integer>(currentPath), paths);
		findRootToLeafPaths(root.getRight(), new ArrayList<Integer>(currentPath), paths);
	}
}
