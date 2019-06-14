package me.deepak.interview.tree.binary.search;

import me.deepak.interview.tree.binary.beans.Node;

/*
 * https://leetcode.com/problems/minimum-distance-between-bst-nodes/
 * https://leetcode.com/problems/minimum-absolute-difference-in-bst/discuss/99905/Two-Solutions-in-order-traversal-and-a-more-general-way-using-TreeSet
*/
public class MinimumAbsoluteDifference {

	private int min = Integer.MAX_VALUE;
	private Integer prev = null;

	public int minDiffInBST(Node root) {

		if (root == null) {
			return min;
		}

		minDiffInBST(root.getLeft());

		if (prev != null) {
			min = Math.min(min, root.getKey() - prev);
		}
		prev = root.getKey();

		minDiffInBST(root.getRight());

		return min;

	}

}
