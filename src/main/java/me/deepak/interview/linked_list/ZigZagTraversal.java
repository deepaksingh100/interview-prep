package me.deepak.interview.linked_list;

import me.deepak.interview.linked_list.beans.Node;

public class ZigZagTraversal {

	private ZigZagTraversal() {
	}

	/*
	 * https://www.geeksforgeeks.org/linked-list-in-zig-zag-fashion/
	 * https://www.geeksforgeeks.org/rearrange-a-linked-list-in-zig-zag-fashion-set-
	 * 2/
	 * https://www.geeksforgeeks.org/converting-an-array-of-integers-into-zig-zag-
	 * fashion/
	 */
	public static Node zigzag(Node head) {

		// base case
		if (head == null || head.getNext() == null) {
			return head;
		}

		Node current = head;

		// islt = true means current.data < current.next.data
		boolean islt = true;

		while (current != null && current.getNext() != null) {
			if (islt) {

				// breaking the order so swap current & current.next
				if (current.getData() > current.getNext().getData()) {
					int temp = current.getData();
					current.setData(current.getNext().getData());
					current.getNext().setData(temp);
				}
			} else {

				// breaking the order so swap current & current.next
				if (current.getData() < current.getNext().getData()) {
					int temp = current.getData();
					current.setData(current.getNext().getData());
					current.getNext().setData(temp);
				}
			}

			// reverse order
			islt = !islt;

			// go to next node
			current = current.getNext();
		}
		return head;
	}
}
