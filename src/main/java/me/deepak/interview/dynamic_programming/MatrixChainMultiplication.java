package me.deepak.interview.dynamic_programming;

public class MatrixChainMultiplication {

	public static int matrixChainMultiplication(int[] dimensions) {
		int n = dimensions.length - 1; // number of matrices
		int[][] table = new int[n + 1][n + 1];
		for (int l = 2; l <= n; l++) { // l is chain length
			for (int i = 1; i <= n - l + 1; i++) {
				int j = i + l - 1;
				table[i][j] = Integer.MAX_VALUE;
				for (int k = i; k < j; k++) {
					int minCost = table[i][k] + table[k + 1][j] + dimensions[i - 1] * dimensions[k] * dimensions[j];
					if (minCost < table[i][j]) {
						table[i][j] = minCost;
					}
				}
			}
		}
		return table[1][n];
	}

	// exactly implemented according to CLRS book
	public static void matrixChainMultiplicationSolution(int[] dimensions) {
		int n = dimensions.length - 1; // number of matrices
		int[][] table = new int[n + 1][n + 1];
		int[][] solution = new int[n][n + 1];
		for (int l = 2; l <= n; l++) { // l is chain length
			for (int i = 1; i <= n - l + 1; i++) {
				int j = i + l - 1;
				table[i][j] = Integer.MAX_VALUE;
				for (int k = i; k < j; k++) {
					int minCost = table[i][k] + table[k + 1][j] + dimensions[i - 1] * dimensions[k] * dimensions[j];
					if (minCost < table[i][j]) {
						table[i][j] = minCost;
						solution[i][j] = k;
					}
				}
			}
		}
		print(solution, 1, n);
	}

	private static void print(int[][] solution, int i, int j) {
		if (i == j) {
			System.out.print("M" + i);
		} else {
			System.out.print("(");
			print(solution, i, solution[i][j]);
			print(solution, solution[i][j] + 1, j);
			System.out.print(")");
		}
	}

}
