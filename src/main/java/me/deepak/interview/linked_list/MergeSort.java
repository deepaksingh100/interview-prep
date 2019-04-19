package me.deepak.interview.linked_list;

import me.deepak.interview.linked_list.beans.Node;

public final class MergeSort {

	private MergeSort() {
	}
	
	public static Node sort(Node head) {
		if (head == null || head.getNext() == null) {
			return head;
		}
		Node mid = getMid(head);
		Node nextToMid = mid.getNext();
		mid.setNext(null);
		Node left = sort(head);
		Node right = sort(nextToMid);
		return merge(left, right);
	}

	public static  Node getMid(Node head) {
		if (head == null || head.getNext() == null) {
			return head;
		}
		Node slowPointer = head;
		Node fastPointer = head;
		while (fastPointer != null && fastPointer.getNext() != null) {
			slowPointer = slowPointer.getNext();
			fastPointer = fastPointer.getNext().getNext();
		}
		return slowPointer;
	}

	public static Node merge(Node left, Node right) {
		if (left == null) {
			return right;
		} else if (right == null) {
			return left;
		} else if (left.getData() < right.getData()) {
			left.setNext(merge(left.getNext(), right));
			return left;
		}
		right.setNext(merge(left, right.getNext()));
		return right;
	}
}
