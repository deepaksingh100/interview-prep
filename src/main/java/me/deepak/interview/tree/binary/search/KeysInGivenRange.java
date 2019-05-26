package me.deepak.interview.tree.binary.search;

import java.util.List;

import me.deepak.interview.tree.binary.beans.Node;

/*
 * https://www.geeksforgeeks.org/print-bst-keys-in-the-given-range/
*/
public class KeysInGivenRange {

	private KeysInGivenRange() {
	}

	/*
	 * The functions prints all the keys which in the given range [key1..key2]. The
	 * function assumes than key1 < key2
	 */
	public static void keysInGivenRange(Node root, int key1, int key2, List<Integer> keys) {

		// base case
		if (root == null) {
			return;
		}

		/*
		 * Since the desired o/p is sorted, recurse for left subtree first If root->data
		 * is greater than key1, then only we can get o/p keys in left subtree
		 */
		if (key1 < root.getKey()) {
			keysInGivenRange(root.getLeft(), key1, key2, keys);
		}

		// if root's data lies in range, then prints root's data
		if (key1 <= root.getKey() && key2 >= root.getKey()) {
			keys.add(root.getKey());
		}

		/*
		 * If root->data is smaller than key2, then only we can get o/p keys in right
		 * subtree
		 */
		if (key2 > root.getKey()) {
			keysInGivenRange(root.getRight(), key1, key2, keys);
		}

	}

}
