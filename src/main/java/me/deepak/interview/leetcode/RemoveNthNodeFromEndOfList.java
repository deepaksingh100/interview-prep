package me.deepak.interview.leetcode;

import me.deepak.interview.leetcode.beans.ListNode;

/*
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
*/

public class RemoveNthNodeFromEndOfList {

	public ListNode removeNthFromEnd(ListNode head, int n) {
		if (n == 0) {
			return head;
		}
		ListNode main = head;
		ListNode ref = head;
		for (int i = 0; i < n; i++) {
			ref = ref.next;
		}
		while (ref != null && ref.next != null) {
			main = main.next;
			ref = ref.next;
		}
		if (ref == null) {
			head = head.next;
		} else {
			main.next = main.next.next;
		}
		return head;
	}

}
