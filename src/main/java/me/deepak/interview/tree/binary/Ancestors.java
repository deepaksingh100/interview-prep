package me.deepak.interview.tree.binary;

import java.util.List;

import me.deepak.interview.tree.binary.beans.Node;

/*
 * https://www.geeksforgeeks.org/print-ancestors-of-a-given-node-in-binary-tree/
*/
public class Ancestors {

	private Ancestors() {
	}

	/*
	 * If target is present in tree, then prints the ancestors and returns true,
	 * otherwise returns false.
	 */
	public static boolean ancestors(Node root, int key, List<Integer> ancestors) {

		// base case
		if (root == null) {
			return false;
		}

		if (root.getKey() == key) {
			return true;
		}

		/*
		 * If target is present in either left or right subtree of this node, then print
		 * this node
		 */
		if (ancestors(root.getLeft(), key, ancestors) || ancestors(root.getRight(), key, ancestors)) {
			ancestors.add(root.getKey());
			return true;
		}

		/* else return false */
		return false;

	}

}
