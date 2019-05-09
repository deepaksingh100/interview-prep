package me.deepak.interview.tree.binary.traversals;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import me.deepak.interview.tree.binary.beans.Node;

/*
 * https://www.geeksforgeeks.org/print-a-binary-tree-in-vertical-order-set-3-using-level-order-traversal/
*/
public class VerticalOrder {

	private VerticalOrder() {
	}

	public static void verticalOrder(Node root) {

		// base case
		if (root == null) {
			return;
		}

		// map of level (left to right) & nodes at that level
		Map<Integer, List<Integer>> map = new HashMap<>();

		// queue to hold nodes
		Queue<Node> nodeQueue = new ArrayDeque<>();

		// queue to hold levels
		Queue<Integer> levelQueue = new ArrayDeque<>();

		nodeQueue.add(root);
		levelQueue.add(0);

		// initialize min & max levels
		int minLevel = 0;
		int maxLevel = 0;

		while (!nodeQueue.isEmpty()) {

			root = nodeQueue.remove();
			int level = levelQueue.remove();

			// update min & max levels
			minLevel = Math.min(minLevel, level);
			maxLevel = Math.max(maxLevel, level);

			// nodes at level
			List<Integer> nodeValues = map.get(level);
			if (nodeValues == null) {
				nodeValues = new ArrayList<>();
			}

			// add current node's value to list & put it to the map
			nodeValues.add(root.getKey());
			map.put(level, nodeValues);

			// go to left with level - 1
			if (root.getLeft() != null) {
				nodeQueue.add(root.getLeft());
				levelQueue.add(level - 1);
			}

			// go to right with level + 1
			if (root.getRight() != null) {
				nodeQueue.add(root.getRight());
				levelQueue.add(level + 1);
			}
		}

		// print level by level nodes
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

}
