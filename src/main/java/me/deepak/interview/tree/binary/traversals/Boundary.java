package me.deepak.interview.tree.binary.traversals;

import static me.deepak.interview.tree.binary.Leaf.isLeaf;

import me.deepak.interview.tree.binary.beans.Node;

/*
 * https://www.geeksforgeeks.org/boundary-traversal-of-binary-tree/
*/
public class Boundary {

	private Boundary() {
	}

	// A function to do boundary traversal of a given binary tree
	public static void printBoundary(Node root) {
		if (root != null) {
			System.out.print(root.getKey() + " ");

			// Print the getLeft() boundary in top-down manner.
			printLeftBoundary(root.getLeft());

			// Print all leaf nodes
			printLeaves(root.getLeft());
			printLeaves(root.getRight());

			// Print the getRight() boundary in bottom-up manner
			printRightBoundary(root.getRight());
		}
	}

	private static void printLeaves(Node root) {
		if (root != null) {
			printLeaves(root.getLeft());

			// Print it if it is a leaf node
			if (isLeaf(root)) {
				System.out.print(root.getKey() + " ");
			}
			printLeaves(root.getRight());
		}
	}

	// A function to print all getLeft() boundary nodes, except a leaf node.
	// Print the nodes in TOP DOWN manner
	private static void printLeftBoundary(Node root) {
		if (root != null) {
			if (root.getLeft() != null) {

				// to ensure top down order, print the node
				// before calling itself for getLeft() subtree
				System.out.print(root.getKey() + " ");
				printLeftBoundary(root.getLeft());
			} else if (root.getRight() != null) {
				System.out.print(root.getKey() + " ");
				printLeftBoundary(root.getRight());
			}

			// do nothing if it is a leaf node, this way we avoid
			// duplicates in output
		}
	}

	// A function to print all getRight() boundary nodes, except a leaf node
	// Print the nodes in BOTTOM UP manner
	private static void printRightBoundary(Node root) {
		if (root != null) {
			if (root.getRight() != null) {

				// to ensure bottom up order, first call for getRight()
				// subtree, then print this node
				printRightBoundary(root.getRight());
				System.out.print(root.getKey() + " ");
			} else if (root.getLeft() != null) {
				printRightBoundary(root.getLeft());
				System.out.print(root.getKey() + " ");
			}
			// do nothing if it is a leaf node, this way we avoid
			// duplicates in output
		}
	}

}
