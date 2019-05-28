package me.deepak.interview.tree.binary.search;

import java.util.ArrayList;
import java.util.List;

import me.deepak.interview.tree.binary.beans.Node;

/*
 * https://www.geeksforgeeks.org/find-a-pair-with-given-sum-in-bst/
*/
public class TwoSum {

	private TwoSum() {
	}

	public static boolean findPair(Node root, int target) {
		List<Integer> list = new ArrayList<>();
		inOrder(root, list);
		int low = 0;
		int high = list.size() - 1;
		while (low < high) {
			if (list.get(low) + list.get(high) < target) {
				low++;
			} else if (list.get(low) + list.get(high) > target) {
				high--;
			} else {
				return true;
			}
		}
		return false;
	}

	private static void inOrder(Node root, List<Integer> list) {
		if (root != null) {
			inOrder(root.getLeft(), list);
			list.add(root.getKey());
			inOrder(root.getRight(), list);
		}
	}

}
