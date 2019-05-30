package me.deepak.interview.dynamic_programming;

/*
 * https://www.geeksforgeeks.org/matrix-chain-multiplication-dp-8/
 * https://www.geeksforgeeks.org/printing-brackets-matrix-chain-multiplication-problem/FO
*/

public class MatrixChainMultiplication {

	private MatrixChainMultiplication() {
	}

	public static int matrixChainMultiplication(int[] dimensions) {
		int length = dimensions.length - 1; // number of matrices

		/*
		 * For simplicity of the program, one extra row and one extra column are
		 * allocated in table[][]. 0th row and 0th column of table[][] are not used
		 */
		int[][] table = new int[length + 1][length + 1];
		for (int l = 2; l <= length; l++) { // l is chain length
			for (int i = 1; i <= length - l + 1; i++) {

				// end index of current sequence is j. start index is i. length is l.
				int j = i + l - 1;
				table[i][j] = Integer.MAX_VALUE;

				// finding break point k for all i < j
				for (int k = i; k < j; k++) {

					/*
					 * table[i][j] = for all i <= k < j min(table[i][k] + table[k + 1][j] +
					 * dimensions[i - 1] * dimensions[k] * dimensions[j])
					 * 
					 */
					int minCost = table[i][k] + table[k + 1][j] + dimensions[i - 1] * dimensions[k] * dimensions[j];
					if (minCost < table[i][j]) {
						table[i][j] = minCost;
					}
				}
			}
		}
		return table[1][length];
	}

	// exactly implemented according to CLRS book
	public static void matrixChainMultiplicationSolution(int[] dimensions) {
		int length = dimensions.length - 1; // number of matrices

		/*
		 * For simplicity of the program, one extra row and one extra column are
		 * allocated in table[][]. 0th row and 0th column of table[][] are not used
		 */
		int[][] table = new int[length + 1][length + 1];

		// solution[i][j] stores optimal break point in subexpression from i to j.
		int[][] solution = new int[length + 1][length + 1];

		/*
		 * table[i,j] = Minimum number of scalar multiplications needed to compute the
		 * matrix A[i]A[i+1]...A[j] = A[i..j] where dimension of A[i] is dimensions[i-1]
		 * x dimensions[i]
		 */

		for (int l = 2; l <= length; l++) { // l is chain length
			for (int i = 1; i <= length - l + 1; i++) {

				// end index of current sequence is j. start index is i. length is l.
				int j = i + l - 1;
				table[i][j] = Integer.MAX_VALUE;

				// finding break point k for all i < j
				for (int k = i; k < j; k++) {

					/*
					 * table[i][j] = for all i <= k < j min(table[i][k] + table[k + 1][j] +
					 * dimensions[i - 1] * dimensions[k] * dimensions[j])
					 * 
					 */
					int minCost = table[i][k] + table[k + 1][j] + dimensions[i - 1] * dimensions[k] * dimensions[j];
					if (minCost < table[i][j]) {
						table[i][j] = minCost;

						/*
						 * Each entry solution[i, j] = k shows where to split the product arr i,i+1....j
						 * for the minimum cost.
						 */
						solution[i][j] = k;
					}
				}
			}
		}
		print(solution, 1, length);
	}

	private static void print(int[][] solution, int i, int j) {
		if (i == j) {
			System.out.print("M" + i);
		} else {
			System.out.print("(");
			int k = solution[i][j];
			print(solution, i, k);
			print(solution, k + 1, j);
			System.out.print(")");
		}
	}

}
