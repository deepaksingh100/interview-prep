package me.deepak.interview.graph;

import java.util.ArrayDeque;
import java.util.Queue;

/*
 * https://www.geeksforgeeks.org/minimum-steps-reach-target-knight/
*/
public class MinStepsToTarget {

	private MinStepsToTarget() {
	}

	// class for storing a cell's data
	private static final class Cell {
		int x;
		int y;
		int distance;

		Cell(int x, int y, int distance) {
			this.x = x;
			this.y = y;
			this.distance = distance;
		}

	}

	// this method returns true if (x, y) lies inside board
	private static boolean valid(int x, int y, int n) {
		return x >= 1 && x <= n && y >= 1 && y <= n;
	}

	// returns minimum step to reach target position
	public static int minSteps(int srcX, int srcY, int targetX, int targetY, int n) {
		boolean[][] visited = new boolean[n + 1][n + 1];

		// queue for storing states of knight in board
		Queue<Cell> queue = new ArrayDeque<>();

		// push starting position of knight with 0 distance
		queue.add(new Cell(srcX, srcY, 0));

		// visit starting state
		visited[srcX][srcY] = true;

		// x and y direction, where a knight can move
		int[][] dirs = { { 2, 1 }, { 2, -1 }, { -2, 1 }, { -2, -1 }, { 1, 2 }, { -1, 2 }, { 1, -2 }, { -1, -2 } };
		while (!queue.isEmpty()) {
			Cell cell = queue.remove();

			// if current cell is equal to target cell, return its distance
			if (cell.x == targetX && cell.y == targetY) {
				return cell.distance;
			}

			// go in all 8 directions
			for (int[] dir : dirs) {

				int x = cell.x + dir[0];
				int y = cell.y + dir[1];

				// if reachable state is not yet visited and inside board, push that state into
				// queue
				if (valid(x, y, n) && !visited[x][y]) {
					queue.add(new Cell(x, y, cell.distance + 1));
					visited[x][y] = true;
				}
			}
		}
		return -1;
	}

}
