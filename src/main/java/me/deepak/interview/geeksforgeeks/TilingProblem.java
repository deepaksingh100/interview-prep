package me.deepak.interview.geeksforgeeks;

/*
 * https://www.geeksforgeeks.org/tiling-problem/
 * https://www.geeksforgeeks.org/count-number-ways-tile-floor-size-n-x-m-using-1-x-m-size-tiles/
*/
public class TilingProblem {

	private TilingProblem() {
	}

	public static long getWays(int n) {
		long[] count = new long[n + 1];
		count[1] = 1;
		count[2] = 2;
		for (int i = 3; i <= n; i++) {
			count[i] = count[i - 1] + count[i - 2];
		}
		return count[n];
	}

	public static int getWays(int n, int m) {
		int[] count = new int[n + 1];

		for (int i = 0; i <= n; i++) {
			if (i > m) {
				count[i] = count[i - 1] + count[i - m];
			} else if (i < m) {
				count[i] = 1;
			} else {
				count[i] = 2;
			}
		}
		return count[n];
	}

}
