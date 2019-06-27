package me.deepak.interview.tree.binary;

import java.util.List;

import me.deepak.interview.tree.binary.beans.Node;

/*
 * https://www.geeksforgeeks.org/print-path-root-given-node-binary-tree/
*/
public class RootToNodePath {

	private RootToNodePath() {
	}

	public static boolean hasPath(Node root, List<Integer> path, int key) {

		// if root is NULL there is no path
		if (root == null) {
			return false;
		}

		// push the node's value in 'path'
		path.add(root.getKey());

		// if it is the required node return true
		if (root.getKey() == key) {
			return true;
		}

		// else check whether the required node lies in the left subtree or right
		// subtree of the current node
		if (hasPath(root.getLeft(), path, key) || hasPath(root.getRight(), path, key)) {
			return true;
		}

		// required node does not lie either in the left or right subtree of the current
		// node Thus, remove current node's value from 'path then return false
		path.remove(path.size() - 1);
		return false;
	}

}
