package me.deepak.interview.leetcode;

import java.util.ArrayList;
import java.util.List;

import me.deepak.interview.leetcode.beans.TreeNode;

/*
 * https://leetcode.com/problems/path-sum-ii/
 * 
 * https://youtu.be/3B5gnrwRmOA
*/
public class PathSum2 {
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<Integer> path = new ArrayList<>();
		List<List<Integer>> paths = new ArrayList<>();
		findPaths(root, sum, path, paths);
		return paths;
	}

	private void findPaths(TreeNode root, int sum, List<Integer> currentPath, List<List<Integer>> paths) {
		if (root == null) {
			return;
		}

		currentPath.add(root.val);
		if (root.left == null && root.right == null && sum == root.val) {
			paths.add(new ArrayList<>(currentPath));
		}

		findPaths(root.left, sum - root.val, currentPath, paths);
		findPaths(root.right, sum - root.val, currentPath, paths);
		currentPath.remove(currentPath.size() - 1);
	}
}
