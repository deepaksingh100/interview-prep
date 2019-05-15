package me.deepak.interview.linked_list;

import me.deepak.interview.linked_list.beans.Node;

public class Mid {

	private Mid() {
	}

	/*
	 * https://www.geeksforgeeks.org/write-a-c-function-to-print-the-middle-of-the-
	 * linked-list/
	 */
	public static Node getMid(Node head) {
		if (head == null || head.getNext() == null) {
			return head;
		}
		Node slowPointer = head;
		Node fastPointer = head;
		while (fastPointer != null && fastPointer.getNext() != null && fastPointer.getNext().getNext() != null) {
			slowPointer = slowPointer.getNext();
			fastPointer = fastPointer.getNext().getNext();
		}
		return slowPointer;
	}

}
