package me.deepak.interview.tree.binary.search;

import me.deepak.interview.tree.binary.beans.Node;

/*
 * https://www.geeksforgeeks.org/shortest-distance-between-two-nodes-in-bst/
*/
public class Distance {

	private Distance() {
	}

	public static int minDistance(Node root, int key1, int key2) {

		// distance(key1, key2) = distance(lca, key1) + distance(lca, key2)
		Node lca = LowestCommonAncestor.getLCA(root, key1, key2);
		return distanceFrom(lca, key1) + distanceFrom(lca, key2);
	}

	private static int distanceFrom(Node root, int key) {
		if (root == null) {
			return -1;
		}
		if (key < root.getKey()) {
			int leftDistance = distanceFrom(root.getLeft(), key);
			return leftDistance == -1 ? -1 : 1 + leftDistance;
		} else if (key > root.getKey()) {
			int rightDistance = distanceFrom(root.getRight(), key);
			return rightDistance == -1 ? -1 : 1 + rightDistance;
		}
		return 0;
	}

}
