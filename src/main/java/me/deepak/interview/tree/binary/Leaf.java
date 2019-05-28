package me.deepak.interview.tree.binary;

import me.deepak.interview.tree.binary.beans.Node;

public class Leaf {

	private Leaf() {
	}

	public static boolean isLeaf(Node root) {
		return root.getLeft() == null && root.getRight() == null;
	}

}
