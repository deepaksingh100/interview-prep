package me.deepak.interview.linked_list;

import me.deepak.interview.linked_list.beans.Node;

public class Insert {

	private Insert() {
	}

	/*
	 * https://www.geeksforgeeks.org/linked-list-set-2-inserting-a-node/
	 */
	public static Node insert(Node head, Node newNode, int position) {
		if (position == 0) {

			// if position is 0, add new node to start and make that new head
			newNode.setNext(head);
			return newNode;
		} else {
			Node current = head;
			int currentPosition = 0;
			while (current != null) {

				// one before position
				if (currentPosition + 1 == position) {

					// insert new node, so that it will take given position
					newNode.setNext(current.getNext());
					current.setNext(newNode);
					break;
				}
				currentPosition++;
				current = current.getNext();
			}
		}
		return head;
	}

}
