package me.deepak.interview.linked_list;

import me.deepak.interview.linked_list.beans.Node;

/*
 * https://www.geeksforgeeks.org/merge-sort-for-linked-list/
*/
public final class MergeSort {

	private MergeSort() {
	}

	public static Node sort(Node head) {

		// base case (0 or 1 nodes)
		if (head == null || head.getNext() == null) {
			return head;
		}

		// get mid node
		Node mid = LinkedList.getMid(head);

		// head for right half
		Node nextToMid = mid.getNext();

		// disconnect left half to right
		mid.setNext(null);

		// sort for left
		Node left = sort(head);

		// sort for right
		Node right = sort(nextToMid);

		// merge sorted left & right half
		return SortedMerge.mergeTwoSortedListsRecursive(left, right);
	}

}
