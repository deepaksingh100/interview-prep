package me.deepak.interview.dynamic_programming;

/*
 * https://www.geeksforgeeks.org/min-cost-path-dp-6/
*/
public class MinCostPath {

	private MinCostPath() {
	}

	public static int getMinCost(int[][] costs, int m, int n) {

		// totalCosts[i][j] represents the total cost to traverse from costs[0][0] to
		// costs[i][j]
		int[][] totalCosts = new int[m + 1][n + 1];

		// total cost to traverse from costs[0][0] to costs[0][0] is costs[0][0]
		totalCosts[0][0] = costs[0][0];

		// total cost of traversal through only first column
		for (int i = 1; i <= m; i++) {
			totalCosts[i][0] = costs[i][0] + totalCosts[i - 1][0];
		}

		// total cost of traversal through only first row
		for (int i = 1; i <= n; i++) {
			totalCosts[0][i] = costs[0][i] + totalCosts[0][i - 1];
		}

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				totalCosts[i][j] = Math.min(totalCosts[i - 1][j] // cost to go up
						, totalCosts[i][j - 1] // cost to go left
				) + costs[i][j];
			}
		}
		return totalCosts[m][n];
	}

	public static int[] getMinCostPath(int[][] costs, int m, int n) {
		
		// totalCosts[i][j] represents the total cost to traverse from costs[0][0] to
		// costs[i][j]
		int[][] totalCosts = new int[m + 1][n + 1];

		// total cost to traverse from costs[0][0] to costs[0][0] is costs[0][0]
		totalCosts[0][0] = costs[0][0];

		// total cost of traversal through only first column
		for (int i = 1; i <= m; i++) {
			totalCosts[i][0] = costs[i][0] + totalCosts[i - 1][0];
		}

		// total cost of traversal through only first row
		for (int i = 1; i <= n; i++) {
			totalCosts[0][i] = costs[0][i] + totalCosts[0][i - 1];
		}

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				totalCosts[i][j] = Math.min(totalCosts[i - 1][j] // cost to go up
						, totalCosts[i][j - 1] // cost to go left
				) + costs[i][j];
			}
		}
		
		int minCostPathLength = totalCosts[m][n];
		int[] minCostPath = new int[minCostPathLength];
		minCostPath[--minCostPathLength] = costs[m][n];
		int i = m;
		int j = n;
		while (minCostPathLength > 0) {
			if (i > 0 && j > 0) {
				if (totalCosts[i - 1][j] < totalCosts[i][j - 1]) {

					// If total cost in upper cell is less than left cell, choose upper
					minCostPath[--minCostPathLength] = costs[--i][j];
				} else {

					// If total cost in left cell is less than upper cell, choose left
					minCostPath[--minCostPathLength] = costs[i][--j];
				}
			} else if (i > 0) {

				// If j == 0, means traversing in first column to up
				minCostPath[--minCostPathLength] = costs[--i][j];
			} else {

				// If i == 0, means traversing in first row to left
				minCostPath[--minCostPathLength] = costs[i][--j];
			}
		}
		return minCostPath;
	}

}
