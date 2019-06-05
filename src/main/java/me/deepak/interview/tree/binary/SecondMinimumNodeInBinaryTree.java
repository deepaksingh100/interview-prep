package me.deepak.interview.tree.binary;

import java.util.Comparator;
import java.util.PriorityQueue;

import me.deepak.interview.tree.binary.beans.Node;

/*
 * https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/
*/
public class SecondMinimumNodeInBinaryTree {

	// custom max heap which stores unique elements
	PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Comparator.reverseOrder()) {

		private static final long serialVersionUID = -4664523284979528321L;

		@Override
		public boolean add(Integer e) {
			boolean isAdded = false;
			if (!super.contains(e)) {
				isAdded = super.add(e);
			}
			return isAdded;
		}
	};

	public int findSecondMinimumValue(Node root) {
		if (root != null) {
			findSecondMinimumValue(root.getLeft());
			maxHeap.add(root.getKey());
			if (maxHeap.size() > 2) {
				maxHeap.remove();
			}
			findSecondMinimumValue(root.getRight());
		}
		return maxHeap.size() >= 2 ? maxHeap.peek() : -1;
	}
}
