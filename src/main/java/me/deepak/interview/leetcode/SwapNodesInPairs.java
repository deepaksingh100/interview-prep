package me.deepak.interview.leetcode;

import me.deepak.interview.leetcode.beans.ListNode;

/*
 * https://leetcode.com/problems/swap-nodes-in-pairs/
*/
public class SwapNodesInPairs {

	public ListNode swapPairs(ListNode head) {
		return reverse2Group(head);
	}

	private ListNode reverse2Group(ListNode head) {
		ListNode curr = head;
		ListNode prev = null;
		ListNode next = null;
		int c = 0;
		while (c < 2 && curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			c++;
		}
		if (next != null) {
			head.next = reverse2Group(next);
		}
		return prev;
	}

}
