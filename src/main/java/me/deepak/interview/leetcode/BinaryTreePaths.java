package me.deepak.interview.leetcode;

import java.util.ArrayList;
import java.util.List;

import me.deepak.interview.leetcode.beans.TreeNode;

/*
 * https://leetcode.com/problems/binary-tree-paths/
*/
public class BinaryTreePaths {

	public List<String> binaryTreePaths(TreeNode root) {
		List<String> paths = new ArrayList<>();
		binaryTreePaths(root, "", paths);
		return paths;
	}

	public void binaryTreePaths(TreeNode root, String path, List<String> paths) {

		if (root == null) {
			return;
		}

		path += root.val;

		if (root.left == null && root.right == null) {
			paths.add(path);
			return;
		}

		binaryTreePaths(root.left, path + "->", paths);
		binaryTreePaths(root.right, path + "->", paths);

	}

}
