package me.deepak.interview.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import me.deepak.interview.leetcode.beans.TreeNode;

/*
 * https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
*/

public class AllNodesDistanceKBinaryTree {

	public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
		Map<TreeNode, TreeNode> nodeToParentMap = new HashMap<>();
		populateNodeToParentMap(nodeToParentMap, root, null);
		Queue<TreeNode> queue = new ArrayDeque<>();
		queue.add(target);
		Set<TreeNode> visited = new HashSet<>();
		visited.add(target);
		int layer = 0;
		while (!queue.isEmpty()) {
			if (layer == k) {
				return extractLayers(queue);
			}
			int size = queue.size();
			while (size-- > 0) {
				TreeNode currentNode = queue.remove();
				if (currentNode.left != null && !visited.contains(currentNode.left)) {
					queue.add(currentNode.left);
					visited.add(currentNode.left);
				}
				if (currentNode.right != null && !visited.contains(currentNode.right)) {
					queue.add(currentNode.right);
					visited.add(currentNode.right);
				}
				TreeNode parentOfCurrentNode = nodeToParentMap.get(currentNode);
				if (parentOfCurrentNode != null && !visited.contains(parentOfCurrentNode)) {
					queue.add(parentOfCurrentNode);
					visited.add(parentOfCurrentNode);
				}
			}
			layer++;
		}
		return new ArrayList<>();
	}

	private void populateNodeToParentMap(Map<TreeNode, TreeNode> nodeToParentMap, TreeNode root, TreeNode parent) {
		if (root == null) {
			return;
		}
		nodeToParentMap.put(root, parent);
		populateNodeToParentMap(nodeToParentMap, root.left, root);
		populateNodeToParentMap(nodeToParentMap, root.right, root);
	}

	private List<Integer> extractLayers(Queue<TreeNode> queue) {
		List<Integer> extractedList = new ArrayList<>();
		for (TreeNode node : queue) {
			extractedList.add(node.val);
		}
		return extractedList;
	}

}