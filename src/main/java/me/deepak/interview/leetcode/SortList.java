package me.deepak.interview.leetcode;

import me.deepak.interview.leetcode.beans.ListNode;

/*
 * https://leetcode.com/problems/sort-list/
*/
public class SortList {

	public ListNode sortList(ListNode head) {

		// base case (0 or 1 nodes)
		if (head == null || head.next == null) {
			return head;
		}

		// get mid node
		ListNode mid = getMid(head);

		// head for right half
		ListNode nextToMid = mid.next;

		// disconnect left half to right
		mid.next = null;

		// sort for left
		ListNode left = sortList(head);

		// sort for right
		ListNode right = sortList(nextToMid);

		// merge sorted left & right half
		return mergeLists(left, right);
	}

	private ListNode getMid(ListNode head) {
		ListNode slowPointer = head;
		ListNode fastPointer = head;

		// NOTE: Take special care of even number of nodes
		while (fastPointer != null && fastPointer.next != null && fastPointer.next.next != null) {
			slowPointer = slowPointer.next;
			fastPointer = fastPointer.next.next;
		}
		return slowPointer;
	}

	private ListNode mergeLists(ListNode head1, ListNode head2) {
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
			head1.next = mergeLists(head1.next, head2);
			return head1;
		}

		// if first list's data is not less than second's, include second's data to
		// final list & call with remaining second list and first list. Return second's
		// head.
		head2.next = mergeLists(head1, head2.next);
		return head2;
	}

}
