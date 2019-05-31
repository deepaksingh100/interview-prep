package me.deepak.interview.linked_list;

import me.deepak.interview.linked_list.beans.Node;

public class Cycle {

	private Cycle() {
	}

	/*
	 * https://www.geeksforgeeks.org/detect-loop-in-a-linked-list/
	 */
	public static boolean hasCycle(Node head) {
		Node slow = head;
		Node fast = head;
		while (fast != null && fast.getNext() != null) {
			slow = slow.getNext();
			fast = fast.getNext().getNext();
			if (slow == fast) {
				return true;
			}
		}
		return false;
	}

	/*
	 * https://www.geeksforgeeks.org/detect-and-remove-loop-in-a-linked-list/
	 */
	public static Node detectCycle(Node head) {
		Node slow = head;
		Node fast = head;
		boolean isLoopExists = false;
		while (fast != null && fast.getNext() != null) {
			slow = slow.getNext();
			fast = fast.getNext().getNext();
			if (slow == fast) {
				isLoopExists = true;
				break;
			}
		}
		if (isLoopExists) {
			slow = head;
			while (slow != fast) {
				slow = slow.getNext();
				fast = fast.getNext();
			}
			return slow;
		}
		return null;
	}

	/*
	 * https://www.geeksforgeeks.org/find-length-of-loop-in-linked-list/
	 */
	public static int countCycleLength(Node head) {
		Node slow = head;
		Node fast = head;
		while (fast != null && fast.getNext() != null) {
			slow = slow.getNext();
			fast = fast.getNext().getNext();
			if (slow == fast) {
				return count(slow);
			}
		}
		return 0;
	}

	private static int count(Node head) {
		int count = 1;
		Node temp = head;
		while (temp.getNext() != head) {
			count++;
			temp = temp.getNext();
		}
		return count;
	}

}
