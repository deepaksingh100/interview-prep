package me.deepak.interview.leetcode;

/*
 * https://leetcode.com/problems/spiral-matrix-ii/
*/
public class SpiralMatrix2 {

	enum Direction {
		LEFT, RIGHT, UP, DOWN
	}

	public int[][] generateMatrix(int n) {
		int[][] matrix = new int[n][n];
		if (n == 0) {
			return matrix;
		}
		int nSquare = n * n;
		int upIndex = 0;
		int downIndex = n - 1;
		int leftIndex = 0;
		int rightIndex = n - 1;
		int count = 1;
		Direction currentDirection = Direction.RIGHT;

		while (count <= nSquare) {

			if (currentDirection == Direction.RIGHT) {

				// traverse in RIGHT Direction (leftIndex to rightIndex)
				for (int i = leftIndex; i <= rightIndex; i++) {
					matrix[upIndex][i] = count++;
				}

				// increase upIndex, now Direction is DOWN
				upIndex++;
				currentDirection = Direction.DOWN;
			} else if (currentDirection == Direction.DOWN) {

				// traverse in DOWN Direction (upIndex to downIndex)
				for (int i = upIndex; i <= downIndex; i++) {
					matrix[i][rightIndex] = count++;
				}

				// decrease rightIndex, now Direction is LEFT
				rightIndex--;
				currentDirection = Direction.LEFT;
			} else if (currentDirection == Direction.LEFT) {

				// traverse in LEFT Direction (rightIndex to leftIndex)
				for (int i = rightIndex; i >= leftIndex; i--) {
					matrix[downIndex][i] = count++;
				}

				// decrease downIndex, now Direction is UP
				downIndex--;
				currentDirection = Direction.UP;
			} else if (currentDirection == Direction.UP) {

				// traverse in UP Direction (downIndex to upIndex)
				for (int i = downIndex; i >= upIndex; i--) {
					matrix[i][leftIndex] = count++;
				}

				// increase leftIndex, now Direction is RIGHT
				leftIndex++;
				currentDirection = Direction.RIGHT;
			}
		}
		return matrix;
	}
}
