package me.deepak.interview.tree.binary.traversals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import me.deepak.interview.tree.binary.beans.Node;

/*
 * https://www.geeksforgeeks.org/diagonal-traversal-of-binary-tree/
 * https://www.gohired.in/2018/02/23/diagonal-traversal-of-binary-tree/
*/
public class Diagonal {

	private Diagonal() {
	}

	public static List<List<Integer>> diagonal(Node root) {

		List<List<Integer>> traversal = new ArrayList<>();

		if (root == null) {
			return traversal;
		}
		Map<Integer, List<Integer>> map = new HashMap<>();
		diagonal(root, map, 0);
		int d = map.size();
		for (int i = 0; i < d; i++) {
			traversal.add(map.get(i));
		}
		return traversal;
	}

	private static void diagonal(Node root, Map<Integer, List<Integer>> map, int d) {
		if (root == null) {
			return;
		}

		List<Integer> list = map.get(d);
		if (list == null) {
			list = new ArrayList<>();
		}
		list.add(root.getKey());
		map.put(d, list);

		// increase the vertical distance if left child
		diagonal(root.getLeft(), map, d + 1);

		// vertical distance remains same for right child
		diagonal(root.getRight(), map, d);
	}

}
