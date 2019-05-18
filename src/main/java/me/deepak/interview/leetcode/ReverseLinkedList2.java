package me.deepak.interview.leetcode;

import me.deepak.interview.leetcode.beans.ListNode;

/*
 * https://leetcode.com/problems/reverse-linked-list-ii/
*/
public class ReverseLinkedList2 {

	public ListNode reverseBetween(ListNode head, int m, int n) {
		if (head == null) {
			return null;
		}

		// create a dummy, insert it before head
		ListNode dummy = new ListNode(0);
		dummy.next = head;

		int count = 1;

		// temp points to (m - 1)th node
		ListNode temp = dummy;
		ListNode curr = head;

		// make temp points to (m - 1)th node
		while (count < m) {
			temp = curr;
			curr = curr.next;
			count++;
		}

		// by this time count would be m, so no need to check for that, below is the
		// standard algo to reverse a given linked list
		ListNode next = null;
		ListNode prev = null;
		while (n >= count) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			count++;
		}

		// curr is (n + 1)th node. temp->next would be last node in reversed list (nth
		// node in final list).
		if (temp.next != null) {
			temp.next.next = curr;
		}

		// point next of temp to first node of reversed list
		temp.next = prev;

		// return effective head
		return dummy.next;
	}

}
