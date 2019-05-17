package me.deepak.interview.linked_list;

import me.deepak.interview.linked_list.beans.Node;

/*
 * https://www.geeksforgeeks.org/function-to-check-if-a-singly-linked-list-is-palindrome/
 * https://leetcode.com/problems/palindrome-linked-list/
*/
public class Palindrome {

	private Palindrome() {
	}

	public static boolean isPalindrome(Node head) {
		if (head == null) {
			return true;
		}
		Node mid = Mid.getMid(head);
		Node head2 = mid.getNext();
		mid.setNext(null);
		head2 = Reverse.reverse(head2);
		Node curr = head;
		Node curr2 = head2;
		boolean isPalindrome = true;
		while (curr2 != null) {
			if (curr.getData() != curr2.getData()) {
				isPalindrome = false;
				break;
			}
			curr = curr.getNext();
			curr2 = curr2.getNext();
		}
		return isPalindrome;
	}

}
