package me.deepak.interview.linked_list;

import me.deepak.interview.linked_list.beans.Node;

/*
 * https://www.geeksforgeeks.org/merge-two-sorted-linked-lists/
*/
public class SortedMerge {

	private SortedMerge() {
	}

	public static Node mergeTwoSortedLists(Node headA, Node headB) {
		if (headA == null) {

			// if first list is empty return second's head
			return headB;
		}
		if (headB == null) {

			// if second list is empty return first's head
			return headA;
		}

		// head of final list
		Node finalHead = null;
		Node currentA = headA;
		Node currentB = headB;

		// setting head of final list
		if (currentA.getData() < currentB.getData()) {
			finalHead = currentA;
			currentA = currentA.getNext();
		} else {
			finalHead = currentB;
			currentB = currentB.getNext();
		}
		finalHead.setNext(null);
		Node currentFinal = finalHead;

		// while both lists have nodes
		while (currentA != null && currentB != null) {
			if (currentA.getData() < currentB.getData()) {
				currentFinal.setNext(currentA);
				currentA = currentA.getNext();
			} else {
				currentFinal.setNext(currentB);
				currentB = currentB.getNext();
			}
			currentFinal = currentFinal.getNext();
			currentFinal.setNext(null);
		}

		if (currentA != null) {

			// if first list was long
			currentFinal.setNext(currentA);
		} else {

			// if second list was long
			currentFinal.setNext(currentB);
		}
		return finalHead;
	}

	public static Node mergeTwoSortedListsRecursive(Node headA, Node headB) {
		if (headA == null) {

			// if first list is empty return second's head
			return headB;
		}
		if (headB == null) {

			// if second list is empty return first's head
			return headA;
		}
		if (headA.getData() < headB.getData()) {

			// if first list's data is less than second's, include first's data to final
			// list & call with remaining first list and second list. Return first's head.
			headA.setNext(mergeTwoSortedListsRecursive(headA.getNext(), headB));
			return headA;
		}

		// if first list's data is not less than second's, include second's data to
		// final list & call with remaining second list and first list. Return second's
		// head.
		headB.setNext(mergeTwoSortedListsRecursive(headA, headB.getNext()));
		return headB;
	}

	public static Node mergeTwoSortedListsReverse(Node headA, Node headB) {
		if (headA == null) {

			// if first list is empty return second's head
			return Reverse.reverse(headB);
		}
		if (headB == null) {

			// if second list is empty return first's head
			return Reverse.reverse(headA);
		}

		Node currentA = headA;
		Node currentB = headB;
		Node currentFinal = null;

		// while both lists have nodes
		while (currentA != null && currentB != null) {
			if (currentA.getData() < currentB.getData()) {
				Node temp = currentA.getNext();
				currentA.setNext(currentFinal);
				currentFinal = currentA;
				currentA = temp;

			} else {
				Node temp = currentB.getNext();
				currentB.setNext(currentFinal);
				currentFinal = currentB;
				currentB = temp;

			}
		}

		// head of final list
		Node finalHead = null;

		if (currentA != null) {

			// if first list was long
			Node temp = currentA;
			finalHead = Reverse.reverse(currentA);
			temp.setNext(currentFinal);
		} else {

			// if second list was long
			Node temp = currentB;
			finalHead = Reverse.reverse(currentB);
			temp.setNext(currentFinal);
		}
		return finalHead;
	}
}
