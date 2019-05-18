package me.deepak.interview.linked_list;

import me.deepak.interview.linked_list.beans.Node;

/*
 * https://leetcode.com/problems/remove-linked-list-elements/
*/
public class Delete {

	private Delete() {
	}

	public static Node delete(Node head, int val) {
		Node curr = head;
		Node prev = null;
		while (curr != null) {
			if (curr.getData() == val) {
				if (prev != null) {
					prev.setNext(curr.getNext());
				} else {
					head = curr.getNext();
				}
			} else {
				prev = curr;
			}
			curr = curr.getNext();
		}
		return head;
	}

}
