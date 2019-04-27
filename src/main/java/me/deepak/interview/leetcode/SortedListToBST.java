package me.deepak.interview.leetcode;

import me.deepak.interview.leetcode.beans.ListNode;
import me.deepak.interview.leetcode.beans.TreeNode;

/*
 * https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
*/

public class SortedListToBST {

	private static ListNode node;

	public TreeNode sortedListToBST(ListNode head) {
		node = head;
		return sortedListToBST(size(head));
	}

	private TreeNode sortedListToBST(int size) {
		if (size == 0) {
			return null;
		}
		TreeNode left = sortedListToBST(size / 2);
		TreeNode root = new TreeNode(node.val);
		root.left = left;
		node = node.next;
		root.right = sortedListToBST(size - size / 2 - 1);
		return root;
	}

	private int size(ListNode head) {
		int size = 0;
		ListNode current = head;
		while (current != null) {
			current = current.next;
			size++;
		}
		return size;
	}

}