package me.deepak.interview.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/problems/spiral-matrix/
*/
public class SpiralMatrix {

	enum Direction {
		LEFT, RIGHT, UP, DOWN
	}

	public List<Integer> spiralOrder(int[][] matrix) {

		// for result
		List<Integer> spiralTraversal = new ArrayList<>();

		// base case
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return spiralTraversal;
		}

		// number of rows & columns
		int rowCount = matrix.length;
		int columnCount = matrix[0].length;

		// boundaries in Direction UP, DOWN, LEFT, RIGHT, basically limits the matrix
		// while traversal
		int upIndex = 0;
		int downIndex = rowCount - 1;
		int leftIndex = 0;
		int rightIndex = columnCount - 1;

		// start traversal in RIGHT Direction
		Direction currentDirection = Direction.RIGHT;

		while (upIndex <= downIndex && leftIndex <= rightIndex) {

			if (currentDirection == Direction.RIGHT) {

				// traverse in RIGHT Direction (leftIndex to rightIndex), add all elements to
				// result of current row
				for (int i = leftIndex; i <= rightIndex; i++) {
					spiralTraversal.add(matrix[upIndex][i]);
				}

				// increase upIndex, now Direction is DOWN
				upIndex++;
				currentDirection = Direction.DOWN;
			} else if (currentDirection == Direction.DOWN) {

				// traverse in DOWN Direction (upIndex to downIndex), add all elements to
				// result of current column
				for (int i = upIndex; i <= downIndex; i++) {
					spiralTraversal.add(matrix[i][rightIndex]);
				}

				// decrease rightIndex, now Direction is LEFT
				rightIndex--;
				currentDirection = Direction.LEFT;
			} else if (currentDirection == Direction.LEFT) {

				// traverse in LEFT Direction (rightIndex to leftIndex), add all elements to
				// result of current row
				for (int i = rightIndex; i >= leftIndex; i--) {
					spiralTraversal.add(matrix[downIndex][i]);
				}

				// decrease downIndex, now Direction is UP
				downIndex--;
				currentDirection = Direction.UP;
			} else if (currentDirection == Direction.UP) {

				// traverse in UP Direction (downIndex to upIndex), add all elements to
				// result of current column
				for (int i = downIndex; i >= upIndex; i--) {
					spiralTraversal.add(matrix[i][leftIndex]);
				}

				// increase leftIndex, now Direction is RIGHT
				leftIndex++;
				currentDirection = Direction.RIGHT;
			}
		}
		return spiralTraversal;
	}
}
