package me.deepak.interview.leetcode;

import me.deepak.interview.leetcode.beans.ListNode;

/*
 * https://leetcode.com/problems/reverse-nodes-in-k-group/
*/
public class ReverseNodesInKGroup {

	public ListNode reverseKGroup(ListNode head, int k) {
		ListNode curr = head;
		ListNode prev = null;
		ListNode next = null;
		int c = 0;

		// reverse k nodes
		while (c < k && curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			c++;
		}

		// reverse next group recursively
		if (next != null) {
			head.next = reverseKGroup(next, k);
		}

		// reverse last group, as it was also reversed
		if (c < k) {
			curr = prev;
			prev = null;
			while (c-- > 0) {
				next = curr.next;
				curr.next = prev;
				prev = curr;
				curr = next;
			}
		}
		return prev;
	}

}
