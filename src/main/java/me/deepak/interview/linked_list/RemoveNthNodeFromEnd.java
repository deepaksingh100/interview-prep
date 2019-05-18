package me.deepak.interview.linked_list;

import me.deepak.interview.linked_list.beans.Node;

/*
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
*/
public class RemoveNthNodeFromEnd {

	private RemoveNthNodeFromEnd() {
	}

	public static Node removeNthFromEnd(Node head, int n) {
		if (n == 0 || head == null) {
			return head;
		}
		Node main = head;
		Node ref = head;
		for (int i = 0; i < n; i++) {
			ref = ref.getNext();
		}

		while (ref != null && ref.getNext() != null) {
			main = main.getNext();
			ref = ref.getNext();
		}

		// ref == null means we reached at end in first iteration, so we need to remove
		// head
		if (ref == null) {
			head = head.getNext();
		} else {
			main.setNext(main.getNext().getNext());
		}
		return head;
	}

}
