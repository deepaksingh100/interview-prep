package me.deepak.interview.tree.binary;

import me.deepak.interview.tree.binary.beans.Node;

/*
 * https://www.lintcode.com/problem/clone-binary-tree/description
*/
public class Clone {

	public Node cloneTree(Node root) {
		if (root == null) {
			return null;
		}
		Node cloneRoot = new Node(root.getKey());
		cloneRoot.setLeft(cloneTree(root.getLeft()));
		cloneRoot.setRight(cloneTree(root.getRight()));
		return cloneRoot;
	}

}
