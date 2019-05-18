package me.deepak.interview.leetcode;

import me.deepak.interview.leetcode.beans.ListNode;

/*
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
*/
public class RemoveNthNodeFromEndOfList {

	public ListNode removeNthFromEnd(ListNode head, int n) {
		if (n == 0 || head == null) {
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

		// ref == null means we reached at end in first iteration, so we need to remove
		// head
		if (ref == null) {
			head = head.next;
		} else {
			main.next = main.next.next;
		}
		return head;
	}

}
