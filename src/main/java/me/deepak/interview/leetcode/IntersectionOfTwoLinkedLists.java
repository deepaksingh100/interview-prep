package me.deepak.interview.leetcode;

import me.deepak.interview.leetcode.beans.ListNode;

/*
 * https://leetcode.com/problems/intersection-of-two-linked-lists/
*/

public class IntersectionOfTwoLinkedLists {

	public ListNode getIntersectionNode(ListNode head1, ListNode head2) {
		int count1 = count(head1);
		int count2 = count(head2);
		if (count1 > count2) {
			return getIntersectionNode(count1 - count2, head1, head2);
		}
		return getIntersectionNode(count2 - count1, head2, head1);
	}

	private int count(ListNode head) {
		ListNode curr = head;
		int count = 0;
		while (curr != null) {
			count++;
			curr = curr.next;
		}
		return count;
	}

	private ListNode getIntersectionNode(int d, ListNode head1, ListNode head2) {
		ListNode curr1 = head1;
		ListNode curr2 = head2;
		for (int i = 0; i < d; i++) {
			curr1 = curr1.next;
		}
		while (curr1 != null && curr2 != null) {
			if (curr1 == curr2) {
				return curr1;
			}
			curr1 = curr1.next;
			curr2 = curr2.next;
		}
		return null;
	}

}
