package me.deepak.interview.linked_list;

/*
 * https://www.geeksforgeeks.org/a-linked-list-with-next-and-arbit-pointer/
*/
public class CopyListWithRandomPointer {

	private CopyListWithRandomPointer() {
	}

	public static Node copyRandomList(Node head) {
		if (head == null) {
			return head;
		}

		// copy every node and insert to list
		Node current = head;
		while (current != null) {
			Node copy = new Node(current.val);
			copy.next = current.next;
			current.next = copy;
			current = copy.next;
		}

		// copy random pointer for each new node
		current = head;
		while (current != null) {
			if (current.random != null) {
				current.next.random = current.random.next;
			}
			current = current.next.next;
		}

		// break list to two
		current = head;
		Node newHead = head.next;
		while (current != null) {
			Node copy = current.next;
			current.next = copy.next;
			if (copy.next != null) {
				copy.next = copy.next.next;
			}
			current = current.next;
		}
		return newHead;
	}

	private static final class Node {
		int val;
		Node next;
		Node random;

		public Node(int val) {
			this.val = val;
		}
	}
}
