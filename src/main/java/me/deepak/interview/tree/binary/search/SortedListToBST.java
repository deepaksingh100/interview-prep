package me.deepak.interview.tree.binary.search;

import me.deepak.interview.linked_list.Length;
import me.deepak.interview.tree.binary.beans.Node;

/*
 * https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
 * https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/solution/
*/
public class SortedListToBST {

	private me.deepak.interview.linked_list.beans.Node node;

	public Node sortedListToBST(me.deepak.interview.linked_list.beans.Node head) {
		node = head;
		return sortedListToBST(Length.length(head));
	}

	private Node sortedListToBST(int size) {
		if (size == 0) {
			return null;
		}
		Node left = sortedListToBST(size / 2);
		Node root = new Node(node.getData());
		root.setLeft(left);
		node = node.getNext();
		root.setRight(sortedListToBST(size / 2 - 1));
		return root;
	}

}
