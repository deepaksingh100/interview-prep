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
		head = prev;
		return head;
	}

}
