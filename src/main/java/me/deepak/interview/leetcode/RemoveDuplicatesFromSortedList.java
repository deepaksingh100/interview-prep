package me.deepak.interview.leetcode;

import me.deepak.interview.leetcode.beans.ListNode;

/*
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/
*/

public class RemoveDuplicatesFromSortedList {

	public ListNode deleteDuplicates(ListNode head) {
		ListNode curr = head;
		while (curr != null && curr.next != null) {
			if (curr.val == curr.next.val) {
				curr.next = curr.next.next;
			} else {
				curr = curr.next;
			}
		}
		return head;
	}

}
