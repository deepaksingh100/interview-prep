package me.deepak.interview.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

import me.deepak.interview.leetcode.beans.TreeNode;

/*
 * https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/
*/
public class SecondMinimumNodeInBinaryTree {

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

	public int findSecondMinimumValue(TreeNode root) {
		if (root != null) {
			findSecondMinimumValue(root.left);
			maxHeap.add(root.val);
			if (maxHeap.size() > 2) {
				maxHeap.remove();
			}
			findSecondMinimumValue(root.right);
		}
		return maxHeap.size() >= 2 ? maxHeap.peek() : -1;
	}
}
