package me.deepak.interview.tree.binary;

import me.deepak.interview.tree.binary.beans.Node;

/*
 * https://www.geeksforgeeks.org/tree-isomorphism-problem/
*/
public class Isomorphic {

	private Isomorphic() {
	}

	public static boolean isIsomorphic(Node root1, Node root2) {

		// both roots are NULL, trees isomorphic by definition
		if (root1 == null && root2 == null) {
			return true;
		}

		// exactly one of the n1 and n2 is NULL, trees not isomorphic
		if (root1 == null || root2 == null) {
			return false;
		}
		if (root1.getKey() != root2.getKey()) {
			return false;
		}

		// There are two possible cases for n1 and n2 to be isomorphic
		// Case 1: The subtrees rooted at these nodes have NOT been "Flipped".
		// Both of these subtrees have to be isomorphic, hence the &&
		// Case 2: The subtrees rooted at these nodes have been "Flipped"
		return (isIsomorphic(root1.getLeft(), root2.getLeft()) && isIsomorphic(root1.getRight(), root2.getRight()))
				|| (isIsomorphic(root1.getLeft(), root2.getRight()) && isIsomorphic(root1.getRight(), root2.getLeft()));
	}

}
