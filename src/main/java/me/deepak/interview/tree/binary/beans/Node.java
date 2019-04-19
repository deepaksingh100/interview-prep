package me.deepak.interview.tree.binary.beans;

public class Node {

	private int key;
	private Node left;
	private Node right;

	public Node(int key) {
		this.key = key;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	@Override
	public String toString() {
		return "Node [key=" + key + ", left=" + left + ", right=" + right + "]";
	}

}
