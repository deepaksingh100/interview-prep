package me.deepak.interview.tree.binary.search;

import me.deepak.interview.tree.binary.beans.Node;

/*
 * https://leetcode.com/problems/range-sum-of-bst/
 * https://leetcode.com/articles/range-sum-of-bst/
*/
public class RangeSum {

	private int sum;

	public int rangeSumBST(Node root, int l, int r) {
		dfs(root, l, r);
		return sum;
	}

	private void dfs(Node root, int l, int r) {

		if (root != null) {

			if (l < root.getKey()) {
				dfs(root.getLeft(), l, r);
			}

			if (r > root.getKey()) {
				dfs(root.getRight(), l, r);
			}

			if (l <= root.getKey() && r >= root.getKey()) {
				sum += root.getKey();
			}

		}

	}

}
