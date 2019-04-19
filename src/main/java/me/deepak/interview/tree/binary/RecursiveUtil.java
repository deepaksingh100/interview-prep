package me.deepak.interview.tree.binary;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import me.deepak.interview.tree.binary.beans.Node;

public class RecursiveUtil {

	private RecursiveUtil() {
	}

	// Traversal

	public static void preOrder(Node root) {
		if (root != null) {
			System.out.print(root.getKey() + " ");
			preOrder(root.getLeft());
			preOrder(root.getRight());
		}
	}

	public static void inOrder(Node root) {
		if (root != null) {
			inOrder(root.getLeft());
			System.out.print(root.getKey() + " ");
			inOrder(root.getRight());
		}
	}

	public static void postOrder(Node root) {
		if (root != null) {
			postOrder(root.getLeft());
			postOrder(root.getRight());
			System.out.print(root.getKey() + " ");
		}
	}

	public static void levelOrder(Node root) {
		int height = height(root);
		for (int i = 1; i <= height; i++) {
			levelOrder(root, i);
		}
	}

	public static void reverseLevelOrder(Node root) {
		int height = height(root);
		for (int i = height; i >= 1; i--) {
			levelOrder(root, i);
		}
	}

	private static void levelOrder(Node root, int level) {
		if (root == null) {
			return;
		}
		if (level == 1) {
			System.out.println(root.getKey() + " ");
		} else {
			levelOrder(root.getLeft(), level - 1);
			levelOrder(root.getRight(), level - 1);
		}
	}

	public static void spiralLevelOrder(Node root) {
		int height = height(root);
		boolean isLeftToRightTraversal = true;
		for (int i = 1; i <= height; i++) {
			spiralLevelOrder(root, i, isLeftToRightTraversal);
			isLeftToRightTraversal = !isLeftToRightTraversal;
		}
	}

	private static void spiralLevelOrder(Node root, int level, boolean isLeftToRightTraversal) {
		if (root == null) {
			return;
		}
		if (level == 1) {
			System.out.println(root.getKey() + " ");
		} else {
			if (isLeftToRightTraversal) {
				spiralLevelOrder(root.getLeft(), level - 1, isLeftToRightTraversal);
				spiralLevelOrder(root.getRight(), level - 1, isLeftToRightTraversal);
			} else {
				spiralLevelOrder(root.getRight(), level - 1, isLeftToRightTraversal);
				spiralLevelOrder(root.getLeft(), level - 1, isLeftToRightTraversal);
			}
		}
	}

	// Size

	public static int size(Node root) {
		if (root == null) {
			return 0;
		}
		return size(root.getLeft()) + size(root.getRight()) + 1;
	}

	// Height

	public static int height(Node root) {
		if (root == null) {
			return 0;
		}
		return Math.max(height(root.getLeft()), height(root.getRight())) + 1;
	}

	// Checks if given 2 binary trees are same in structure and in value

	public static boolean isSameTree(Node root1, Node root2) {
		if (root1 == null && root2 == null) {
			return true;
		} else if (root1 == null || root2 == null) {
			return false;
		}
		return root1.getKey() == root2.getKey() && isSameTree(root1.getLeft(), root2.getLeft())
				&& isSameTree(root1.getRight(), root2.getRight());
	}

	// Checks if there exists a path from root to leaf which has given sum

	public static boolean isRootToLeafSumExists(Node root, int sum, List<Integer> result) {
		if (root == null) {
			return false;
		}
		if (root.getLeft() == null && root.getRight() == null) {
			if (root.getKey() == sum) {
				result.add(root.getKey());
				return true;
			} else {
				return false;
			}
		}
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

	// Assumes both keys must present in tree.
	// One must assure that both keys exist in tree by searching them prior to
	// calling this method. Call this method only iff both keys exist in tree.

	public static Node lowestCommonAncestor(Node root, int key1, int key2) {
		if (root == null || root.getKey() == key1 || root.getKey() == key2) {
			return root;
		}
		Node left = lowestCommonAncestor(root.getLeft(), key1, key2);
		Node right = lowestCommonAncestor(root.getRight(), key1, key2);
		if (left != null && right != null) {
			return root;
		}
		return left != null ? left : right;
	}

	class Height {
		int h = 0;
	}

	public int diameter(Node root, Height height) {
		if (root == null) {
			return 0;
		}
		Height leftHeight = new Height();
		Height rightHeight = new Height();
		int leftDiameter = diameter(root.getLeft(), leftHeight);
		int rightDiameter = diameter(root.getRight(), rightHeight);
		height.h = Math.max(leftHeight.h, rightHeight.h) + 1;
		return Math.max(leftHeight.h + rightHeight.h + 1, Math.max(leftDiameter, rightDiameter));
	}

	public static int distance(Node root, int key1, int key2) {
		Node lca = lowestCommonAncestor(root, key1, key2);
		return distanceFromRoot(lca, key1, 0) + distanceFromRoot(lca, key2, 0);
	}

	private static int distanceFromRoot(Node root, int key, int distance) {
		if (root == null) {
			return -1;
		}
		if (root.getKey() == key) {
			return distance;
		}
		int leftDistance = distanceFromRoot(root.getLeft(), key, distance + 1);
		return leftDistance == -1 ? distanceFromRoot(root.getRight(), key, distance + 1) : leftDistance;
	}

	// to show pre processing of map for building a tree

	public static Node buildTree(int[] inOrder, int[] postOrder, int start, int end) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = start; i <= end; i++) {
			map.put(inOrder[i], i);
		}
		return buildTreeFromInOrderAndPostOrder(inOrder, start, end, postOrder, start, end, map);
	}

	public static Node buildTreeFromInOrderAndPostOrder(int[] inOrder, int inStart, int inEnd, int[] postOrder,
			int postStart, int postEnd, Map<Integer, Integer> map) {
		if (inStart > inEnd || postStart > postEnd) {
			return null;
		}
		int rootValue = postOrder[postEnd];
		Node root = new Node(rootValue);
		int index = map.get(rootValue);
		root.setLeft(buildTreeFromInOrderAndPostOrder(inOrder, inStart, index - 1, postOrder, postStart,
				postEnd + index - inEnd - 1, map));
		root.setRight(buildTreeFromInOrderAndPostOrder(inOrder, index + 1, inEnd, postOrder, postEnd + index - inEnd,
				postEnd - 1, map));
		return root;
	}

	public static Node buildTreeFromInOrderAndPreOrder(int[] inOrder, int inStart, int inEnd, int[] preOrder,
			int preStart, int preEnd, Map<Integer, Integer> map) {
		if (inStart > inEnd || preStart > preEnd) {
			return null;
		}
		int rootValue = preOrder[preStart];
		Node root = new Node(rootValue);
		int index = map.get(rootValue);
		root.setLeft(buildTreeFromInOrderAndPreOrder(inOrder, inStart, index - 1, preOrder, preStart + 1,
				preEnd + index - inEnd, map));
		root.setRight(buildTreeFromInOrderAndPreOrder(inOrder, index + 1, inEnd, preOrder, preEnd + index + 1 - inEnd,
				preEnd, map));
		return root;
	}

	public static Node buildTreeFromInOrderAndLevelOrder(int[] inOrder, int[] levelOrder, int inStart, int inEnd,
			Map<Integer, Integer> map) {
		if (inStart > inEnd) {
			return null;
		}
		int rootValue = levelOrder[0];
		Node root = new Node(rootValue);
		int index = map.get(rootValue);
		int[] leftLevel = extractLevel(levelOrder, inStart, index - 1, map);
		int[] rightLevel = extractLevel(levelOrder, index + 1, inEnd, map);
		root.setLeft(buildTreeFromInOrderAndLevelOrder(inOrder, leftLevel, inStart, index - 1, map));
		root.setRight(buildTreeFromInOrderAndLevelOrder(inOrder, rightLevel, index + 1, inEnd, map));
		return root;
	}

	private static int[] extractLevel(int[] levelOrder, int start, int end, Map<Integer, Integer> map) {
		int[] level = new int[end - start + 1];
		int count = 0;
		for (int i = 0; i < levelOrder.length; i++) {
			int index = map.get(levelOrder[i]);
			if (index >= start && index <= end) {
				level[count++] = levelOrder[i];
			}
		}
		return level;
	}

	public boolean isBalanced(Node root, Height height) {
		if (root == null) {
			return true;
		}
		Height leftHeight = new Height();
		Height rightHeight = new Height();
		boolean isLeftBalanced = isBalanced(root.getLeft(), leftHeight);
		boolean isRightBalanced = isBalanced(root.getRight(), rightHeight);
		height.h = Math.max(leftHeight.h, rightHeight.h) + 1;
		return Math.abs(leftHeight.h - rightHeight.h) <= 1 && isLeftBalanced && isRightBalanced;
	}

}
