package me.deepak.interview.tree.binary.search;

import me.deepak.interview.tree.binary.beans.Node;

/*
 * https://www.geeksforgeeks.org/kth-largest-element-in-bst-when-modification-to-bst-is-not-allowed/
*/
public class KthLargestElementInBST {

	private KthLargestElementInBST() {
	}

	private static int count;
	private static int ans;

	public static int kthLargest(Node root, int k) {
		count = 0;
		ans = -1;
		kthLargestHelper(root, k);
		return ans;
	}

	private static void kthLargestHelper(Node root, int k) {

		if (root == null || count >= k) {
			return;
		}

		kthLargestHelper(root.getRight(), k);

		if (k == ++count) {
			ans = root.getKey();
			return;
		}

		kthLargestHelper(root.getLeft(), k);

	}

}
