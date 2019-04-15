package me.deepak.interview.dynamic_programming;

public class MinCostPath {

	public static int getMinCost(int[][] costs, int m, int n) {
		int[][] table = new int[m + 1][n + 1];
		table[0][0] = costs[0][0];
		for (int i = 1; i <= m; i++) {
			table[i][0] = costs[i][0] + table[i - 1][0];
		}
		for (int i = 1; i <= n; i++) {
			table[0][i] = costs[0][i] + table[0][i - 1];
		}
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				table[i][j] = Math.min(table[i - 1][j], table[i][j - 1]) + costs[i][j];
			}
		}
		return table[m][n];
	}

	public static int[] getMinCostPath(int[][] costs, int m, int n) {
		int[][] table = new int[m + 1][n + 1];
		table[0][0] = costs[0][0];
		for (int i = 1; i <= m; i++) {
			table[i][0] = costs[i][0] + table[i - 1][0];
		}
		for (int i = 1; i <= n; i++) {
			table[0][i] = costs[0][i] + table[0][i - 1];
		}
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				table[i][j] = Math.min(table[i - 1][j], table[i][j - 1]) + costs[i][j];
			}
		}
		int minCostPathLength = table[m][n];
		int[] minCostPath = new int[minCostPathLength];
		minCostPath[--minCostPathLength] = costs[m][n];
		while (minCostPathLength > 0) {
			if (m > 0 && n > 0) {
				if (table[m - 1][n] < table[m][n - 1]) {
					minCostPath[minCostPathLength - 1] = costs[m - 1][n];
					minCostPathLength--;
					m--;
				} else {
					minCostPath[minCostPathLength - 1] = costs[m][n - 1];
					minCostPathLength--;
					n--;
				}
			} else if (m > 0) {
				minCostPath[minCostPathLength - 1] = costs[m - 1][n];
				minCostPathLength--;
				m--;
			} else {
				minCostPath[minCostPathLength - 1] = costs[m][n - 1];
				minCostPathLength--;
				n--;
			}
		}
		return minCostPath;
	}

}
