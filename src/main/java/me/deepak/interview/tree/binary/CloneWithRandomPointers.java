package me.deepak.interview.tree.binary;

import java.util.HashMap;
import java.util.Map;

/*
 * https://www.geeksforgeeks.org/clone-binary-tree-random-pointers/
*/
public class CloneWithRandomPointers {

	private static class Node {
		int data;
		Node left;
		Node right;
		Node random;

		public Node(int data) {
			this.data = data;
		}
	}

	public Node cloneTree(Node root) {
		if (root == null) {
			return null;
		}
		Map<Node, Node> map = new HashMap<>();
		Node cloneRoot = copyLeftRight(root, map);
		copyRandom(root, cloneRoot, map);
		return cloneRoot;
	}

	private Node copyLeftRight(Node root, Map<Node, Node> map) {
		if (root == null) {
			return null;
		}
		Node cloneRoot = new Node(root.data);
		map.put(root, cloneRoot);
		cloneRoot.left = copyLeftRight(root.left, map);
		cloneRoot.right = copyLeftRight(root.right, map);
		return cloneRoot;
	}

	private void copyRandom(Node root, Node cloneRoot, Map<Node, Node> map) {
		if (root == null) {
			return;
		}
		cloneRoot.random = map.get(root.random);
		copyRandom(root.left, cloneRoot.left, map);
		copyRandom(root.right, cloneRoot.right, map);
	}

}
