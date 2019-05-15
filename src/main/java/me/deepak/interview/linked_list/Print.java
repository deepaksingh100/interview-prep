package me.deepak.interview.linked_list;

import me.deepak.interview.linked_list.beans.Node;

public class Print {

	private Print() {
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

}
