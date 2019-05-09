package me.deepak.interview.tree.binary.traversals;

import static me.deepak.interview.tree.binary.Height.getHeight;

import java.util.ArrayDeque;

import me.deepak.interview.tree.binary.beans.Node;

/*
 * https://www.geeksforgeeks.org/level-order-traversal-in-spiral-form/
*/
public class SpiralOrder {

	private SpiralOrder() {
	}

	// O(n^2)
	public static void spiralOrder(Node root) {
		int height = getHeight(root);

		// true, if we need to traverse from left to right
		boolean isLeftToRightTraversal = true;

		// traversing top to bottom
		for (int i = 1; i <= height; i++) {
			spiralOrder(root, i, isLeftToRightTraversal);
			isLeftToRightTraversal = !isLeftToRightTraversal;
		}
	}

	private static void spiralOrder(Node root, int level, boolean isLeftToRightTraversal) {

		// base case
		if (root == null) {
			return;
		}

		// if we are at given level, print values
		if (level == 1) {
			System.out.println(root.getKey() + " ");
		} else {
			if (isLeftToRightTraversal) {
				spiralOrder(root.getLeft(), level - 1, isLeftToRightTraversal);
				spiralOrder(root.getRight(), level - 1, isLeftToRightTraversal);
			} else {
				spiralOrder(root.getRight(), level - 1, isLeftToRightTraversal);
				spiralOrder(root.getLeft(), level - 1, isLeftToRightTraversal);
			}
		}
	}

	public static void spiralOrderIterative(Node root) {

		/*
		 * This algo traverses first (even) level left to right, second (odd) level
		 * right to left & so on. We are using deque to implement this. If level is
		 * even, we are doing simple level order traversal. If level is odd, we are
		 * doing just opposite of even level. As you know for even levels :
		 * 
		 * 1. dequeue node from queue (means dequeue from front of queue)
		 * 
		 * 2. print data of dequeued node
		 * 
		 * 3. if left is not null, enqueue it to queue (means enqueue at rear of queue)
		 * 
		 * 4. if right is not null, enqueue it to queue (means enqueue at rear of queue)
		 * 
		 * 5. repeat until deque is empty
		 * 
		 * Just oppositely, for odd levels :
		 * 
		 * 1. dequeue node from rear of queue
		 * 
		 * 2. print data of dequeued node
		 * 
		 * 3. if right is not null, enqueue it at front of queue
		 * 
		 * 4. if left is not null, enqueue it at front of queue
		 * 
		 * 5. repeat until deque is empty
		 */

		// base case
		if (root == null) {
			return;
		}

		ArrayDeque<Node> deque = new ArrayDeque<>();
		deque.add(root);

		// at even level traverse left to right, else right to left
		boolean evenLevel = true;

		while (!deque.isEmpty()) {
			int size = deque.size();
			if (evenLevel) {

				// print current even level
				while (size-- > 0) {
					root = deque.removeFirst();
					System.out.print(root.getKey() + " ");
					if (root.getLeft() != null) {
						deque.addLast(root.getLeft());
					}
					if (root.getRight() != null) {
						deque.addLast(root.getRight());
					}
				}
			} else {

				// print current odd level
				while (size-- > 0) {
					root = deque.removeLast();
					System.out.print(root.getKey() + " ");
					if (root.getRight() != null) {
						deque.addFirst(root.getRight());
					}
					if (root.getLeft() != null) {
						deque.addFirst(root.getLeft());
					}
				}
			}
			evenLevel = !evenLevel;
		}
	}

}
