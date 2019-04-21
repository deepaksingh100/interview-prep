package me.deepak.interview.leetcode;

import me.deepak.interview.leetcode.beans.ListNode;

/*
 * https://leetcode.com/problems/remove-linked-list-elements/
*/

public class RemoveLinkedListElements {

	public ListNode removeElements(ListNode head, int val) {
		ListNode curr = head;
		ListNode prev = null;
		while (curr != null) {
			if (curr.val == val) {
				if (prev != null) {
					prev.next = curr.next;
				} else {
					head = curr.next;
				}
				curr = curr.next;
			} else {
				prev = curr;
				curr = curr.next;
			}
		}
		return head;
	}

}
