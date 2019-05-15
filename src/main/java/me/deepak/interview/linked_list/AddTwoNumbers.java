package me.deepak.interview.linked_list;

import me.deepak.interview.linked_list.beans.Node;

/*
 * https://leetcode.com/problems/add-two-numbers/
 * https://www.geeksforgeeks.org/add-two-numbers-represented-by-linked-lists/
*/

public class AddTwoNumbers {

	private AddTwoNumbers() {
	}

	public static Node addTwoNumbers(Node l1, Node l2) {
		Node head = null;
		Node current = null;
		int sum = 0;
		int carry = 0;
		while (l1 != null || l2 != null) {
			if (l1 != null) {
				sum += l1.getData();
				l1 = l1.getNext();
			}
			if (l2 != null) {
				sum += l2.getData();
				l2 = l2.getNext();
			}
			sum += carry;
			carry = sum / 10;
			sum %= 10;
			Node newNode = new Node(sum);
			sum = 0;
			if (head != null) {
				current.setNext(newNode);
				current = current.getNext();
			} else {
				head = newNode;
				current = head;
			}
		}
		if (carry > 0) {
			current.setNext(new Node(carry));
		}
		return head;
	}

}
