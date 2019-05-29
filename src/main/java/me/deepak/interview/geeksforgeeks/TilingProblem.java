package me.deepak.interview.geeksforgeeks;

/*
 * https://www.geeksforgeeks.org/tiling-problem/
*/
public class TilingProblem {

	private TilingProblem() {
	}

	public static int getWays(int n) {
		return n > 1 ? getWays(n - 1) + getWays(n - 2) : -1;
	}

}
