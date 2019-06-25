package me.deepak.interview.tree.binary.search;

import static me.deepak.interview.tree.binary.search.LowestCommonAncestor.findLCA;

import me.deepak.interview.tree.binary.beans.Node;

/*
 * https://www.geeksforgeeks.org/shortest-distance-between-two-nodes-in-bst/
*/
public class Distance {

	private Distance() {
	}

	public static int minDistance(Node root, int key1, int key2) {

		// distance(key1, key2) = distance(lca, key1) + distance(lca, key2)
		Node lca = findLCA(root, key1, key2);
		if (lca == null) {
			return -1;
		}
		return distanceFrom(lca, key1, 0) + distanceFrom(lca, key2, 0);
	}

	private static int distanceFrom(Node root, int key, int distance) {

		// key is not found
		if (root == null) {
			return -1;
		}

		// if key is found, return distance
		if (key == root.getKey()) {
			return distance;
		}

		// if key < root's key, go left
		if (key < root.getKey()) {
			return distanceFrom(root.getLeft(), key, distance + 1);
		}

		// if key > root's key, go right
		return distanceFrom(root.getRight(), key, distance + 1);

	}

}
