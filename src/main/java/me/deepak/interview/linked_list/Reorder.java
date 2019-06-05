package me.deepak.interview.linked_list;

import me.deepak.interview.linked_list.beans.Node;

public class Reorder {

	private Reorder() {
	}

	public static Node reorder(Node head) {
		if (head == null || head.getNext() == null) {
			return head;
		}
		Node mid = Mid.getMid(head);
		Node nextToMid = mid.getNext();
		mid.setNext(null);
		nextToMid = Reverse.reverse(nextToMid);
		Node curr1 = head;
		Node curr2 = nextToMid;
		while (curr2 != null) {
			Node temp = curr2.getNext();
			curr2.setNext(curr1.getNext());
			curr1.setNext(curr2);
			curr1 = curr1.getNext().getNext();
			curr2 = temp;
		}
		return head;
	}

}
