package me.deepak.interview.dynamic_programming;

public class EditDistance {

	public static int editDistance(String s1, String s2, int n1, int n2) {
		int[][] table = new int[n1 + 1][n2 + 1];
		for (int i = 0; i <= n1; i++) {
			for (int j = 0; j <= n2; j++) {
				if (i == 0 || j == 0) {
					table[i][j] = Math.max(i, j);
				} else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					table[i][j] = table[i - 1][j - 1];
				} else {
					table[i][j] = 1 + Math.min(table[i][j - 1], Math.min(table[i - 1][j], table[i - 1][j - 1]));
				}
			}
		}
		return table[n1][n2];
	}

}
