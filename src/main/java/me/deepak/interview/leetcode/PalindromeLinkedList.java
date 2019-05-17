package me.deepak.interview.leetcode;

import me.deepak.interview.leetcode.beans.ListNode;

/*
 * https://leetcode.com/problems/palindrome-linked-list/
*/
public class PalindromeLinkedList {

	public boolean isPalindrome(ListNode head) {
		if (head == null) {
			return true;
		}
		ListNode mid = getMid(head);
		ListNode head2 = mid.next;
		mid.next = null;
		head2 = reverse(head2);
		ListNode curr = head;
		ListNode curr2 = head2;
		boolean isPalindrome = true;
		while (curr2 != null) {
			if (curr.val != curr2.val) {
				isPalindrome = false;
				break;
			}
			curr = curr.next;
			curr2 = curr2.next;
		}
		return isPalindrome;
	}

	private ListNode getMid(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
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
