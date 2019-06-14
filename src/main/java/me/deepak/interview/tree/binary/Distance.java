package me.deepak.interview.tree.binary;

import static me.deepak.interview.tree.binary.LowestCommonAncestor.getLCA;

import me.deepak.interview.tree.binary.beans.Node;

/*
 * https://www.geeksforgeeks.org/find-distance-between-two-nodes-of-a-binary-tree/
*/
public class Distance {

	private Distance() {
	}

	public static int minDistance(Node root, int key1, int key2) {

		// distance(key1, key2) = distance(lca, key1) + distance(lca, key2)
		Node lca = getLCA(root, key1, key2);
		int key1Distance = distanceFrom(lca, key1, 0);
		return key1Distance == -1 ? -1 : key1Distance + distanceFrom(lca, key2, 0);
	}

	public static int distanceFrom(Node root, int key, int distance) {

		// key is not found
		if (root == null) {
			return -1;
		}

		// if key is found, return distance
		if (root.getKey() == key) {
			return distance;
		}

		// call for left subtree
		int leftDistance = distanceFrom(root.getLeft(), key, distance + 1);

		// if key is found in left subtree, return distance else call for right subtree
		return leftDistance == -1 ? distanceFrom(root.getRight(), key, distance + 1) : leftDistance;
	}

}
