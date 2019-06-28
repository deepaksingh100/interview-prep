package me.deepak.interview.tree.binary.traversals;

import me.deepak.interview.tree.binary.beans.Node;

/*
 * https://www.geeksforgeeks.org/boundary-traversal-of-binary-tree/
*/
public class Boundary {

	private Boundary() {
	}

	// A function to do boundary traversal of a given binary tree
	public static void printBoundary(Node node) {
		if (node != null) {
			System.out.print(node.getKey() + " ");

			// Print the getLeft() boundary in top-down manner.
			printBoundaryLeft(node.getLeft());

			// Print all leaf nodes
			printLeaves(node.getLeft());
			printLeaves(node.getRight());

			// Print the getRight() boundary in bottom-up manner
			printBoundaryRight(node.getRight());
		}
	}

	private static void printLeaves(Node node) {
		if (node != null) {
			printLeaves(node.getLeft());

			// Print it if it is a leaf node
			if (node.getLeft() == null && node.getRight() == null) {
				System.out.print(node.getKey() + " ");
			}
			printLeaves(node.getRight());
		}
	}

	// A function to print all getLeft() boundary nodes, except a leaf node.
	// Print the nodes in TOP DOWN manner
	private static void printBoundaryLeft(Node node) {
		if (node != null) {
			if (node.getLeft() != null) {

				// to ensure top down order, print the node
				// before calling itself for getLeft() subtree
				System.out.print(node.getKey() + " ");
				printBoundaryLeft(node.getLeft());
			} else if (node.getRight() != null) {
				System.out.print(node.getKey() + " ");
				printBoundaryLeft(node.getRight());
			}

			// do nothing if it is a leaf node, this way we avoid
			// duplicates in output
		}
	}

	// A function to print all getRight() boundary nodes, except a leaf node
	// Print the nodes in BOTTOM UP manner
	private static void printBoundaryRight(Node node) {
		if (node != null) {
			if (node.getRight() != null) {

				// to ensure bottom up order, first call for getRight()
				// subtree, then print this node
				printBoundaryRight(node.getRight());
				System.out.print(node.getKey() + " ");
			} else if (node.getLeft() != null) {
				printBoundaryRight(node.getLeft());
				System.out.print(node.getKey() + " ");
			}
			// do nothing if it is a leaf node, this way we avoid
			// duplicates in output
		}
	}

}
