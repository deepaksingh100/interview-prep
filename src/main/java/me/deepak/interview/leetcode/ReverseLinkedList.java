package me.deepak.interview.leetcode;

import me.deepak.interview.leetcode.beans.ListNode;

/*
 * https://leetcode.com/problems/reverse-linked-list/
*/

public class ReverseLinkedList {

	public ListNode reverseList(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode curr = head;
		ListNode prev = null;
		ListNode next = null;
		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}

}
