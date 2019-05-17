package me.deepak.interview.linked_list;

import me.deepak.interview.linked_list.beans.Node;

/*
 * https://leetcode.com/problems/intersection-of-two-linked-lists/
 * https://www.geeksforgeeks.org/write-a-function-to-get-the-intersection-point-of-two-linked-lists/
*/
public class Intersection {

	private Intersection() {
	}

	public Node getIntersectionNode(Node head1, Node head2) {
		int count1 = Length.length(head1);
		int count2 = Length.length(head2);

		if (count1 > count2) {
			return getIntersectionNode(count1 - count2, head1, head2);
		}
		return getIntersectionNode(count2 - count1, head2, head1);
	}

	private Node getIntersectionNode(int d, Node head1, Node head2) {
		Node curr1 = head1;
		Node curr2 = head2;
		for (int i = 0; i < d; i++) {
			curr1 = curr1.getNext();
		}

		while (curr1 != null && curr2 != null) {
			if (curr1 == curr2) {
				return curr1;
			}
			curr1 = curr1.getNext();
			curr2 = curr2.getNext();
		}
		return null;
	}

}
