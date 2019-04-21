package me.deepak.interview.leetcode;

import me.deepak.interview.leetcode.beans.ListNode;

/*
 * https://leetcode.com/problems/add-two-numbers-ii/
*/

public class AddTwoNumbers2 {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		l1 = reverse(l1);
		l2 = reverse(l2);
		ListNode result = null;
		ListNode resultHead = null;
		int sum = 0;
		int carry = 0;
		while (l1 != null || l2 != null) {
			if (l1 != null) {
				sum += l1.val;
				l1 = l1.next;
			}
			if (l2 != null) {
				sum += l2.val;
				l2 = l2.next;
			}
			sum += carry;
			carry = sum / 10;
			sum %= 10;
			ListNode node = new ListNode(sum);
			sum = 0;
			if (resultHead != null) {
				result.next = node;
				result = result.next;
			} else {
				result = node;
				resultHead = result;
			}
		}
		if (carry > 0) {
			ListNode node = new ListNode(carry);
			result.next = node;
		}
		return reverse(resultHead);
	}

	private ListNode reverse(ListNode head) {
		ListNode curr = head;
		ListNode prev = null;
		ListNode next = null;
		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}

}
