package me.deepak.interview.linked_list;

import me.deepak.interview.linked_list.beans.Node;

/*
 * https://www.geeksforgeeks.org/sort-linked-list-0s-1s-2s-changing-links/
*/
public class Sort {

	private Sort() {
	}

	public static Node segregate012s(Node head) {

		// Create three dummy nodes to point to beginning of three linked lists. These
		// dummy nodes are created to avoid many null checks.
		Node zeroDummy = new Node(0);
		Node oneDummy = new Node(0);
		Node twoDummy = new Node(0);

		// current pointers for zeroDummy, oneDummy, twoDummy & given list
		Node zero = zeroDummy;
		Node one = oneDummy;
		Node two = twoDummy;
		Node curr = head;

		// traverse list
		while (curr != null) {
			if (curr.getData() == 0) {
				zero.setNext(curr);
				zero = zero.getNext();
			} else if (curr.getData() == 1) {
				one.setNext(curr);
				one = one.getNext();
			} else {
				two.setNext(curr);
				two = two.getNext();
			}
			curr = curr.getNext();
		}

		// attach three lists
		zero.setNext(oneDummy.getNext() != null ? oneDummy.getNext() : twoDummy.getNext());
		one.setNext(twoDummy.getNext());
		two.setNext(null);
		head = zeroDummy.getNext();
		return head;
	}

}
