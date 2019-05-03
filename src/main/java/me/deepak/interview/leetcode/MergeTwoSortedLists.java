package me.deepak.interview.leetcode;

import me.deepak.interview.leetcode.beans.ListNode;

/*
 * https://leetcode.com/problems/merge-two-sorted-lists/
*/
public class MergeTwoSortedLists {

	public ListNode mergeTwoLists(ListNode head1, ListNode head2) {
		if (head1 == null) {

			// if first list is empty return second's head
			return head2;
		}
		if (head2 == null) {

			// if second list is empty return first's head
			return head1;
		}
		if (head1.val < head2.val) {

			// if first list's data is less than second's, include first's data to final
			// list & call with remaining first list and second list. Return first's head.
			head1.next = mergeTwoLists(head1.next, head2);
			return head1;
		}

		// if first list's data is not less than second's, include second's data to
		// final list & call with remaining second list and first list. Return second's
		// head.
		head2.next = mergeTwoLists(head1, head2.next);
		return head2;
	}

}
