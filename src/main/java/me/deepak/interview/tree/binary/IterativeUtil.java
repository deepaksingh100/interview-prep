package me.deepak.interview.tree.binary;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import me.deepak.interview.tree.binary.beans.Node;

public class IterativeUtil {

	private IterativeUtil() {
	}

	// Traversal

	public static void preOrder(Node root) {
		if (root == null) {
			return;
		}
		ArrayDeque<Node> stack = new ArrayDeque<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			root = stack.pop();
			System.out.print(root.getKey() + " ");
			if (root.getRight() != null) {
				stack.push(root.getRight());
			}
			if (root.getLeft() != null) {
				stack.push(root.getLeft());
			}
		}
	}

	public static void inOrder(Node root) {
		if (root == null) {
			return;
		}
		ArrayDeque<Node> stack = new ArrayDeque<>();
		while (true) {
			if (root != null) {
				stack.push(root);
				root = root.getLeft();
			} else {
				if (stack.isEmpty()) {
					return;
				}
				root = stack.pop();
				System.out.print(root.getKey() + " ");
				root = root.getRight();
			}
		}
	}

	public static void postOrder(Node root) {
		if (root == null) {
			return;
		}
		ArrayDeque<Node> stack1 = new ArrayDeque<>();
		ArrayDeque<Node> stack2 = new ArrayDeque<>();
		stack1.push(root);
		while (!stack1.isEmpty()) {
			root = stack1.pop();
			stack2.push(root);
			if (root.getLeft() != null) {
				stack1.push(root.getLeft());
			}
			if (root.getRight() != null) {
				stack1.push(root.getRight());
			}
		}
		while (!stack2.isEmpty()) {
			System.out.print(stack2.pop().getKey() + " ");
		}
	}

	public static void postOrderWithOneStack(Node root) {
		Node current = root;
		ArrayDeque<Node> stack = new ArrayDeque<>();
		while (current != null || !stack.isEmpty()) {
			if (current != null) {
				stack.push(current);
				current = current.getLeft();
			} else {
				Node temp = stack.peek().getRight();
				if (temp == null) {
					temp = stack.pop();
					System.out.print(temp.getKey() + " ");
					while (!stack.isEmpty() && temp == stack.peek().getRight()) {
						System.out.print(stack.pop().getKey() + " ");
					}
				} else {
					current = temp;
				}
			}
		}
	}

	public static void levelOrder(Node root) {
		if (root == null) {
			return;
		}
		Queue<Node> queue = new ArrayDeque<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			root = queue.remove();
			System.out.print(root.getKey() + " ");
			if (root.getLeft() != null) {
				queue.add(root.getLeft());
			}
			if (root.getRight() != null) {
				queue.add(root.getRight());
			}
		}
	}

	public static void reverseLevelOrder(Node root) {
		if (root == null) {
			return;
		}
		Queue<Node> queue = new ArrayDeque<>();
		ArrayDeque<Node> stack = new ArrayDeque<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			root = queue.remove();
			stack.push(root);
			if (root.getRight() != null) {
				queue.add(root.getRight());
			}
			if (root.getLeft() != null) {
				queue.add(root.getLeft());
			}
		}
		while (!stack.isEmpty()) {
			System.out.print(stack.pop().getKey() + " ");
		}
	}

	public static void spiralLevelOrder(Node root) { // first level left to right and so on
		if (root == null) {
			return;
		}
		ArrayDeque<Node> deque = new ArrayDeque<>();
		deque.add(root);
		int level = 0;
		while (!deque.isEmpty()) {
			int size = deque.size();
			if ((level & 1) == 0) {
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
			level++;
		}
	}

	public static void verticalOrder(Node root) {
		if (root == null) {
			return;
		}
		Map<Integer, List<Integer>> map = new HashMap<>();
		Queue<Node> nodeQueue = new ArrayDeque<>();
		Queue<Integer> levelQueue = new ArrayDeque<>();
		nodeQueue.add(root);
		levelQueue.add(0);
		int minLevel = 0;
		int maxLevel = 0;
		while (!nodeQueue.isEmpty()) {
			root = nodeQueue.remove();
			int level = levelQueue.remove();
			minLevel = Math.min(minLevel, level);
			maxLevel = Math.max(maxLevel, level);
			List<Integer> nodeValues = map.get(level);
			if (nodeValues == null) {
				nodeValues = new ArrayList<>();
			}
			nodeValues.add(root.getKey());
			map.put(level, nodeValues);
			if (root.getLeft() != null) {
				nodeQueue.add(root.getLeft());
				levelQueue.add(level - 1);
			}
			if (root.getRight() != null) {
				nodeQueue.add(root.getRight());
				levelQueue.add(level + 1);
			}
		}
		for (int i = minLevel; i <= maxLevel; i++) {
			if (map.containsKey(i)) {
				List<Integer> values = map.get(i);
				for (int value : values) {
					System.out.print(value + " ");
				}
				System.out.println();
			}
		}
	}

	// Size

	public static int size(Node root) {
		if (root == null) {
			return 0;
		}
		Queue<Node> queue = new ArrayDeque<>();
		queue.add(root);
		int size = 0;
		while (!queue.isEmpty()) {
			root = queue.remove();
			size++;
			if (root.getLeft() != null) {
				queue.add(root.getLeft());
			}
			if (root.getRight() != null) {
				queue.add(root.getRight());
			}
		}
		return size;
	}

	// Height

	public static int height(Node root) {
		if (root == null) {
			return 0;
		}
		Queue<Node> queue = new ArrayDeque<>();
		queue.add(root);
		int height = 0;
		while (true) {
			int nodeCount = queue.size();
			if (nodeCount == 0) {
				return height;
			}
			height++;
			while (nodeCount > 0) {
				root = queue.remove();
				nodeCount--;
				if (root.getLeft() != null) {
					queue.add(root.getLeft());
				}
				if (root.getRight() != null) {
					queue.add(root.getRight());
				}
			}
		}
	}

}
