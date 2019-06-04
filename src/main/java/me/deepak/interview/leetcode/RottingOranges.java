package me.deepak.interview.leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

/*
 * https://leetcode.com/problems/rotting-oranges/
 * https://leetcode.com/problems/rotting-oranges/discuss/238681/Java-Clean-BFS-Solution-with-comments
*/
public class RottingOranges {

	public int orangesRotting(int[][] grid) {

		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}

		int rows = grid.length;
		int cols = grid[0].length;
		Queue<int[]> queue = new ArrayDeque<>();
		int countFresh = 0;

		// Put the position of all rotten oranges in queue & count the number of fresh
		// oranges
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (grid[i][j] == 2) {
					queue.add(new int[] { i, j });
				} else if (grid[i][j] == 1) {
					countFresh++;
				}
			}
		}

		// if count of fresh oranges is zero, return 0
		if (countFresh == 0) {
			return 0;
		}

		int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
		int count = 0;

		// bfs starting from initially rotten oranges
		while (!queue.isEmpty()) {
			count++;
			int size = queue.size();

			while (size-- > 0) {

				int[] point = queue.remove();

				for (int[] dir : dirs) {

					int x = point[0] + dir[0];
					int y = point[1] + dir[1];

					// if x or y is out of bound or the orange at (x , y) is already rotten or the
					// cell at (x , y) is empty we do nothing
					if (x < 0 || y < 0 || x >= rows || y >= cols || grid[x][y] != 1) {
						continue;
					}

					// mark the orange at (x , y) as rotten
					grid[x][y] = 2;

					// put the new rotten orange at (x , y) in queue
					queue.add(new int[] { x, y });

					// decrease the count of fresh oranges by 1
					countFresh--;

				}
			}
		}

		// Because here we are counting the initial state of the oranges (at 0th minute)
		// as well. That's why, we have to subtract 1 from the final count.
		return countFresh == 0 ? count - 1 : -1;

	}

}
