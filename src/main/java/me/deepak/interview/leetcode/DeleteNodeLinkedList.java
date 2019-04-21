package me.deepak.interview.leetcode;

import me.deepak.interview.leetcode.beans.ListNode;

/*
 * https://leetcode.com/problems/delete-node-in-a-linked-list/
*/

public class DeleteNodeLinkedList {

	public void deleteNode(ListNode node) {
		node.val = node.next.val;
		node.next = node.next.next;
	}

}
