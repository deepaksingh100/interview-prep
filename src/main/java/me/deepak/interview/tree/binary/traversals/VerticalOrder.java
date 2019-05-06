package me.deepak.interview.tree.binary.traversals;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import me.deepak.interview.tree.binary.beans.Node;

public class VerticalOrder {

	private VerticalOrder() {
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

}
