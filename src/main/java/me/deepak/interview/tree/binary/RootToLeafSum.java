package me.deepak.interview.tree.binary;

import java.util.ArrayList;
import java.util.List;

import me.deepak.interview.leetcode.beans.TreeNode;
import me.deepak.interview.tree.binary.beans.Node;

public class RootToLeafSum {

	private RootToLeafSum() {
	}

	/*
	 * https://www.geeksforgeeks.org/root-to-leaf-path-sum-equal-to-a-given-number/
	 */
	public static boolean isRootToLeafSumExists(Node root, int sum, List<Integer> result) {

		if (root == null) {
			return false;
		}

		// root is leaf node
		if (root.getLeft() == null && root.getRight() == null) {
			if (root.getKey() == sum) {
				result.add(root.getKey());
				return true;
			}
			return false;
		}

		// recur with sum - current key for left & right subtree
		if (isRootToLeafSumExists(root.getLeft(), sum - root.getKey(), result)) {
			result.add(root.getKey());
			return true;
		}

		if (isRootToLeafSumExists(root.getRight(), sum - root.getKey(), result)) {
			result.add(root.getKey());
			return true;
		}

		return false;
	}

	/*
	 * https://leetcode.com/problems/path-sum-ii/
	 * 
	 * https://youtu.be/3B5gnrwRmOA
	 */
	public static void findRootToLeafSumPaths(TreeNode root, int sum, List<Integer> currentPath,
			List<List<Integer>> paths) {
		if (root == null) {
			return;
		}

		// add current value
		currentPath.add(root.val);

		if (root.left == null && root.right == null && sum == root.val) {

			// if required path found add it to paths
			paths.add(new ArrayList<>(currentPath));
		}

		// recur for left & right subtree
		findRootToLeafSumPaths(root.left, sum - root.val, currentPath, paths);
		findRootToLeafSumPaths(root.right, sum - root.val, currentPath, paths);

		// remove last entry
		currentPath.remove(currentPath.size() - 1);
	}

}
