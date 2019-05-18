package me.deepak.interview.linked_list;

import me.deepak.interview.linked_list.beans.Node;

public class Reverse {

	private Reverse() {
	}

	/*
	 * https://www.geeksforgeeks.org/reverse-a-linked-list/
	 */
	public static Node reverse(Node head) {
		Node prev = null;
		Node curr = head;
		Node next = null;
		while (curr != null) {
			next = curr.getNext();
			curr.setNext(prev);
			prev = curr;
			curr = next;
		}
		return prev;
	}

	public Node reverseBetween(Node head, int m, int n) {
		if (head == null) {
			return null;
		}

		// create a dummy, insert it before head
		Node dummy = new Node(0);
		dummy.setNext(head);

		int count = 1;

		// temp points to (m - 1)th node
		Node temp = dummy;
		Node curr = head;

		// make temp points to (m - 1)th node
		while (count < m) {
			temp = curr;
			curr = curr.getNext();
			count++;
		}

		// by this time count would be m, so no need to check for that, below is the
		// standard algo to reverse a given linked list
		Node next = null;
		Node prev = null;
		while (n >= count) {
			next = curr.getNext();
			curr.setNext(prev);
			prev = curr;
			curr = next;
			count++;
		}

		// curr is (n + 1)th node. temp->next would be last node in reversed list (nth
		// node in final list).
		if (temp.getNext() != null) {
			temp.getNext().setNext(curr);
		}

		// point next of temp to first node of reversed list
		temp.setNext(prev);

		// return effective head
		return dummy.getNext();
	}

	public Node reverseKGroup(Node head, int k) {
		Node curr = head;
		Node prev = null;
		Node next = null;
		int c = 0;

		// reverse k nodes
		while (c < k && curr != null) {
			next = curr.getNext();
			curr.setNext(prev);
			prev = curr;
			curr = next;
			c++;
		}

		// reverse next group recursively
		if (next != null) {
			head.setNext(reverseKGroup(next, k));
		}

		// reverse last group, as it was also reversed
		if (c < k) {
			curr = prev;
			prev = null;
			while (c-- > 0) {
				next = curr.getNext();
				curr.setNext(prev);
				prev = curr;
				curr = next;
			}
		}
		return prev;
	}

}
