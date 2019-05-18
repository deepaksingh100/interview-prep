package me.deepak.interview.linked_list;

import me.deepak.interview.linked_list.beans.Node;

/*
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/
*/
public class RemoveDuplicatesFromSortedList {

	private RemoveDuplicatesFromSortedList() {
	}

	public static Node deleteDuplicates(Node head) {
		Node curr = head;
		while (curr != null && curr.getNext() != null) {
			if (curr.getData() == curr.getNext().getData()) {
				curr.setNext(curr.getNext().getNext());
			} else {
				curr = curr.getNext();
			}
		}
		return head;
	}

}
