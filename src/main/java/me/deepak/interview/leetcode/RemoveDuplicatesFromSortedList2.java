package me.deepak.interview.leetcode;

import me.deepak.interview.leetcode.beans.ListNode;

/*
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
*/

public class RemoveDuplicatesFromSortedList2 {

	public ListNode deleteDuplicates(ListNode head) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode curr = head;
		ListNode prev = dummy;
		while (curr != null) {
			while (curr.next != null && prev.next.val == curr.next.val) {
				curr = curr.next;
			}
			if (prev.next == curr) {
				prev = curr;
			} else {
				prev.next = curr.next;
			}
			curr = curr.next;
		}
		return dummy.next;
	}

}
