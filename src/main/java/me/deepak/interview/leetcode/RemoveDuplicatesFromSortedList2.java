package me.deepak.interview.leetcode;

import me.deepak.interview.leetcode.beans.ListNode;

/*
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
*/
public class RemoveDuplicatesFromSortedList2 {

	public ListNode deleteDuplicates(ListNode head) {

		// create dummy node, insert it before head
		ListNode dummy = new ListNode(0);
		dummy.next = head;

		// pointer to iterate over list
		ListNode curr = head;

		// prev points just before curr, but if we found any duplicates, prev will be
		// pointing to the node just before duplicates
		ListNode prev = dummy;

		while (curr != null && curr.next != null) {

			if (prev.next.val != curr.next.val) {

				// check if we have found duplicates in between or not
				if (prev.next == curr) {

					// if we have not found duplicates in between, just advance prev to curr
					prev = curr;
				} else {

					// if we have found duplicates in between, we can't advance prev further, just
					// skip all duplicates & set prev's next to next of curr
					prev.next = curr.next;
				}
			}

			// this will be executed in all case means we advance curr to it's next in each
			// iteration
			curr = curr.next;
		}

		// if next of prev is not curr, then we are assured that after prev there are
		// only duplicates, thus ending list at prev
		if (prev.next != curr) {
			prev.next = null;
		}

		// return dummy's next which is original head
		return dummy.next;
	}

}
