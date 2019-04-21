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
		int c = 1;
		ListNode curr = head;
		ListNode prev = null;
		ListNode next = null;
		ListNode left = null;
		ListNode mNode = null;
		while (curr != null) {
			if (c >= m && c <= n) {
				if (c == m) {
					mNode = curr;
				}
				next = curr.next;
				curr.next = prev;
				prev = curr;
				curr = next;
			} else {
				if (c == m - 1) {
					left = curr;
				}
				if (c == n + 1) {
					mNode.next = curr;
				}
				curr = curr.next;
			}
			c++;
		}
		if (left != null) {
			left.next = prev;
		} else {
			head = prev;
		}
		return head;
	}

}
