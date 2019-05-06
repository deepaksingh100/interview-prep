package me.deepak.interview.tree.binary;

import static me.deepak.interview.tree.binary.LowestCommonAncestor.getLCA;

import me.deepak.interview.tree.binary.beans.Node;

public class Distance {

	private Distance() {
	}

	public static int distance(Node root, int key1, int key2) {
		Node lca = getLCA(root, key1, key2);
		return distanceFromRoot(lca, key1, 0) + distanceFromRoot(lca, key2, 0);
	}

	public static int distanceFromRoot(Node root, int key, int distance) {
		if (root == null) {
			return -1;
		}
		if (root.getKey() == key) {
			return distance;
		}
		int leftDistance = distanceFromRoot(root.getLeft(), key, distance + 1);
		return leftDistance == -1 ? distanceFromRoot(root.getRight(), key, distance + 1) : leftDistance;
	}

}
