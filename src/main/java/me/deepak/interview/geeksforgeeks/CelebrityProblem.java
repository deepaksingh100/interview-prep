package me.deepak.interview.geeksforgeeks;

/*
 * https://www.geeksforgeeks.org/the-celebrity-problem/
*/
public class CelebrityProblem {

	private CelebrityProblem() {
	}

	public static int getId(int[][] acquaintanceMatrix) {

		int peopleCount = acquaintanceMatrix.length;

		// Initialize two pointers as two corners
		int a = 0;
		int b = peopleCount - 1;

		// Keep moving while the two pointers don't become same.
		while (a < b) {
			if (knows(acquaintanceMatrix, a, b)) {
				a++;
			} else {
				b--;
			}
		}

		// Check if a is actually a celebrity or not
		for (int i = 0; i < peopleCount; i++) {

			// If any person doesn't know 'a' or 'a' knows at least one person, return -1
			if (a != i && (knows(acquaintanceMatrix, a, i) || !knows(acquaintanceMatrix, i, a))) {
				return -1;
			}
		}

		return a;
	}

	private static boolean knows(int[][] acquaintanceMatrix, int i, int j) {
		return acquaintanceMatrix[i][j] == 1;
	}

}
