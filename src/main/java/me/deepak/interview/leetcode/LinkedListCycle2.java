package me.deepak.interview.leetcode;

import me.deepak.interview.leetcode.beans.ListNode;

/*
 * https://leetcode.com/problems/linked-list-cycle-ii/
*/

public class LinkedListCycle2 {

	public ListNode detectCycle(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		boolean isLoopExists = false;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				isLoopExists = true;
				break;
			}
		}
		if (isLoopExists) {
			slow = head;
			while (slow != fast) {
				slow = slow.next;
				fast = fast.next;
			}
			return slow;
		}
		return null;
	}

}
