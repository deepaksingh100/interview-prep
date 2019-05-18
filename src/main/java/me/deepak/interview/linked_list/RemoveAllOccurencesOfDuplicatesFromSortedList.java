package me.deepak.interview.linked_list;

import me.deepak.interview.linked_list.beans.Node;

/*
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
*/
public class RemoveAllOccurencesOfDuplicatesFromSortedList {

	private RemoveAllOccurencesOfDuplicatesFromSortedList() {
	}

	public static Node deleteDuplicates(Node head) {

		// create dummy node, insert it before head
		Node dummy = new Node(0);
		dummy.setNext(head);

		// pointer to iterate over list
		Node curr = head;

		// prev points just before curr, but if we found any duplicates, prev will be
		// pointing to the node just before duplicates
		Node prev = dummy;

		while (curr != null && curr.getNext() != null) {

			if (prev.getNext().getData() != curr.getNext().getData()) {

				// check if we have found duplicates in between or not
				if (prev.getNext() == curr) {

					// if we have not found duplicates in between, just advance prev to curr
					prev = curr;
				} else {

					// if we have found duplicates in between, we can't advance prev further, just
					// skip all duplicates & set prev's next to next of curr
					prev.setNext(curr.getNext());
				}
			}

			// this will be executed in all case means we advance curr to it's next in each
			// iteration
			curr = curr.getNext();
		}

		// if next of prev is not curr, then we are assured that after prev there are
		// only duplicates, thus ending list at prev
		if (prev.getNext() != curr) {
			prev.setNext(null);
		}

		// return dummy's next which is original head
		return dummy.getNext();
	}

}
