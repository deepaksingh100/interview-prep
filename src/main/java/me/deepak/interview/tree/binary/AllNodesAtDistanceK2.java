package me.deepak.interview.tree.binary;

import java.util.ArrayList;
import java.util.List;

import me.deepak.interview.tree.binary.beans.Node;

/*
 * https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
 * https://www.geeksforgeeks.org/print-nodes-distance-k-given-node-binary-tree/
*/
public class AllNodesAtDistanceK2 {

	public List<Integer> distanceK(Node root, Node target, int k) {
		List<Integer> result = new ArrayList<>();
		distanceK(root, target, k, result);
		return result;
	}

	/*
	 * Returns list of all nodes at distance k from a given target node. The k
	 * distant nodes may be upward or downward. This function Returns distance of
	 * root from target node, it returns -1 if target node is not present in tree
	 * rooted with root.
	 */
	private int distanceK(Node root, Node target, int k, List<Integer> result) {

		// Base Case 1: If tree is empty, return -1
		if (root == null) {
			return -1;
		}

		// If target is same as root. Use the downward function to print all nodes at
		// distance k in subtree rooted with target or root
		if (root == target) {
			distanceK(root, k, result);
			return 0;
		}

		// Recur for left subtree
		int distanceLeft = distanceK(root.getLeft(), target, k, result);

		// Check if target node was found in left subtree
		if (distanceLeft != -1) {

			// If root is at distance k from target, add root to result. NOTE that
			// distanceLeft is distance of root's left child from target.
			if (distanceLeft + 1 == k) {
				result.add(root.getKey());
			} else {

				// Else go to right subtree and add all k-distanceLeft-2 distant nodes to
				// result. NOTE that the right child is 2 edges away from left child
				distanceK(root.getRight(), k - distanceLeft - 2, result);
			}

			// Add 1 to the distance and return value for parent calls
			return 1 + distanceLeft;
		}

		// MIRROR OF ABOVE CODE FOR RIGHT SUBTREE
		// Note that we reach here only when node was not found in left subtree
		int distanceRight = distanceK(root.getRight(), target, k, result);
		if (distanceRight != -1) {
			if (distanceRight + 1 == k) {
				result.add(root.getKey());
			} else {
				distanceK(root.getLeft(), k - distanceRight - 2, result);
			}
			return 1 + distanceRight;
		}

		// If target was neither present in left nor in right subtree
		return -1;
	}

	private void distanceK(Node root, int k, List<Integer> result) {

		// Base Case
		if (root == null || k < 0) {
			return;
		}

		// If we reach a k distant node, add it to result
		if (k == 0) {
			result.add(root.getKey());
			return;
		}

		// Recur for left and right subtrees
		distanceK(root.getLeft(), k - 1, result);
		distanceK(root.getRight(), k - 1, result);
	}

}