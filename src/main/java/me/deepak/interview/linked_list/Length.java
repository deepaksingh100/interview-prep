package me.deepak.interview.linked_list;

import me.deepak.interview.linked_list.beans.Node;

public class Length {

	private Length() {
	}

	/*
	 * https://www.geeksforgeeks.org/find-length-of-a-linked-list-iterative-and-
	 * recursive/
	 */
	public static int length(Node head) {
		int length = 0;
		Node current = head;
		while (current != null) {
			length++;
			current = current.getNext();
		}
		return length;
	}

}
