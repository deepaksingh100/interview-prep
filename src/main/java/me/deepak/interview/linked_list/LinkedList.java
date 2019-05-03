package me.deepak.interview.linked_list;

import me.deepak.interview.linked_list.beans.Node;

public final class LinkedList {

	private LinkedList() {
	}

	/*
	 * https://www.geeksforgeeks.org/linked-list-set-1-introduction/
	 */
	public static void printList(Node head) {
		if (head == null) {
			System.out.println("No elements found in the list");
		} else {
			System.out.println("Elements found in the list are : ");
			Node current = head;
			while (current != null) {
				System.out.print(current.getData() + " ");

				// go to next node, will be used in every method
				current = current.getNext();
			}
		}
	}

	/*
	 * https://www.geeksforgeeks.org/find-length-of-a-linked-list-iterative-and-
	 * recursive/
	 */
	public static int length(Node head) {
		int length = 0;
		Node current = head;
		while (current != null) {
			length++;
			current = current.getNext();
		}
		return length;
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

	/*
	 * https://www.geeksforgeeks.org/reverse-a-linked-list/
	 */
	public static Node reverse(Node head) {
		Node prev = null;
		Node curr = head;
		Node next = null;
		while (curr != null) {
			next = curr.getNext();
			curr.setNext(prev);
			prev = curr;
			curr = next;
		}
		head = prev;
		return head;
	}

	/*
	 * https://www.geeksforgeeks.org/write-a-c-function-to-print-the-middle-of-the-
	 * linked-list/
	 */
	public static Node getMid(Node head) {
		if (head == null || head.getNext() == null) {
			return head;
		}
		Node slowPointer = head;
		Node fastPointer = head;
		while (fastPointer != null && fastPointer.getNext() != null && fastPointer.getNext().getNext() != null) {
			slowPointer = slowPointer.getNext();
			fastPointer = fastPointer.getNext().getNext();
		}
		return slowPointer;
	}

	/*
	 * https://www.geeksforgeeks.org/linked-list-in-zig-zag-fashion/
	 * https://www.geeksforgeeks.org/rearrange-a-linked-list-in-zig-zag-fashion-set-
	 * 2/
	 * https://www.geeksforgeeks.org/converting-an-array-of-integers-into-zig-zag-
	 * fashion/
	 */
	public static Node zigzag(Node head) {

		// base case
		if (head == null || head.getNext() == null) {
			return head;
		}

		Node current = head;

		// islt = true means current.data < current.next.adata
		boolean islt = true;

		while (current != null && current.getNext() != null) {
			if (islt) {

				// breaking the order so swap current & current.next
				if (current.getData() > current.getNext().getData()) {
					int temp = current.getData();
					current.setData(current.getNext().getData());
					current.getNext().setData(temp);
				}
			} else {

				// breaking the order so swap current & current.next
				if (current.getData() < current.getNext().getData()) {
					int temp = current.getData();
					current.setData(current.getNext().getData());
					current.getNext().setData(temp);
				}
			}

			// reverse order
			islt = !islt;

			// go to next node
			current = current.getNext();
		}
		return head;
	}

}
