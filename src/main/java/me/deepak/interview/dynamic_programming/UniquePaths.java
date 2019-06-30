package me.deepak.interview.dynamic_programming;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/unique-paths/
 * https://leetcode.com/problems/unique-paths/discuss/22953/Java-DP-solution-with-complexity-O(n*m)
*/
public class UniquePaths {

	public int uniquePaths(int m, int n) {

		int[][] paths = new int[m][n];

		for (int i = 0; i < m; i++) {
			paths[i][0] = 1;
		}

		for (int i = 0; i < n; i++) {
			paths[0][i] = 1;
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				paths[i][j] = paths[i][j - 1] + paths[i - 1][j];
			}
		}
		return paths[m - 1][n - 1];
	}

	public int uniquePathsSpaceOptimized(int m, int n) {

		if (m == 0 || n == 0) {
			return 0;
		}

		if (m == 1 || n == 1) {
			return 1;
		}

		int[] paths = new int[n];

		Arrays.fill(paths, 1);

		for (int i = 1; i < m; i++) {

			for (int j = 1; j < n; j++) {
				paths[j] += paths[j - 1];
			}
		}
		return paths[n - 1];
	}

}
