package me.deepak.interview.linked_list;

import me.deepak.interview.linked_list.beans.Node;

public final class LinkedList {

	private LinkedList() {
	}

	public static void printList(Node head) {
		if (head == null) {
			System.out.println("No elements found in the list");
		} else {
			System.out.println("Elements found in the list are : ");
			Node current = head;
			while (current != null) {
				System.out.println(current.getData());
				current = current.getNext();
			}
		}
	}

	public static int length(Node head) {
		int length = 0;
		Node current = head;
		while (current != null) {
			length++;
			current = current.getNext();
		}
		return length;
	}

	public static void insert(Node head, Node newNode, int position) {
		if (position == 0) {
			newNode.setNext(head);
			head = newNode;
		} else {
			Node current = head;
			int currentPosition = 0;
			while (current != null) {
				if (currentPosition + 1 == position) {
					newNode.setNext(current.getNext());
					current.setNext(newNode);
					break;
				}
				currentPosition++;
				current = current.getNext();
			}
		}
		printList(head);
	}

	public static void reverse(Node head) {
		if (head == null) {
			return;
		}
		Node prev = null;
		Node current = head;
		Node next = null;
		while (current != null) {
			next = current.getNext();
			current.setNext(prev);
			prev = current;
			current = next;
		}
		printList(prev);
	}

	public static Node mergeLists(Node headA, Node headB) {
		if (headA == null)
			return headB;
		else if (headB == null)
			return headA;
		Node finalHead = null;
		Node currentA = headA;
		Node currentB = headB;
		if (currentA.getData() < currentB.getData()) {
			finalHead = currentA;
			currentA = currentA.getNext();
		} else {
			finalHead = currentB;
			currentB = currentB.getNext();
		}
		finalHead.setNext(null);
		Node currentFinal = finalHead;
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
			currentFinal.setNext(currentA);
		} else {
			currentFinal.setNext(currentB);
		}
		return finalHead;
	}

	public static Node zigzag(Node head) {
		if (head == null || head.getNext() == null)
			return head;
		Node current = head;
		boolean islt = true;
		while (current != null && current.getNext() != null) {
			if (islt) {
				if (current.getData() > current.getNext().getData()) {
					int temp = current.getData();
					current.setData(current.getNext().getData());
					current.getNext().setData(temp);
				}
			} else {
				if (current.getData() < current.getNext().getData()) {
					int temp = current.getData();
					current.setData(current.getNext().getData());
					current.getNext().setData(temp);
				}
			}
			islt = !islt;
			current = current.getNext();
		}
		return head;
	}

}
