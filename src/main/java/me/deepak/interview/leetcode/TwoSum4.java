package me.deepak.interview.leetcode;

import java.util.ArrayList;
import java.util.List;

import me.deepak.interview.leetcode.beans.TreeNode;

/*
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
*/
public class TwoSum4 {

	public boolean findTarget(TreeNode root, int k) {
		List<Integer> inOrder = new ArrayList<>();
		inOrder(root, inOrder);
		int i = 0;
		int j = inOrder.size() - 1;
		while (i < j) {
			if (inOrder.get(i) + inOrder.get(j) < k) {
				i++;
			} else if (inOrder.get(i) + inOrder.get(j) > k) {
				j--;
			} else {
				return true;
			}
		}
		return false;
	}

	private void inOrder(TreeNode root, List<Integer> inOrder) {
		if (root != null) {
			inOrder(root.left, inOrder);
			inOrder.add(root.val);
			inOrder(root.right, inOrder);
		}
	}

}
