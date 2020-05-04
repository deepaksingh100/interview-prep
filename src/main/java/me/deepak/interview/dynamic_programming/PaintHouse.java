package me.deepak.interview.dynamic_programming;

/*
 * https://leetfree.com/problems/paint-house.html
 * https://www.programcreek.com/2014/05/leetcode-paint-house-java/
 * https://www.quora.com/How-do-I-solve-the-colorful-street-problem-using-top-down-dynamic-programming
 * https://www.hackerearth.com/practice/algorithms/dynamic-programming/introduction-to-dynamic-programming-1/practice-problems/algorithm/the-colorful-street-1/
*/
public class PaintHouse {

	public int minCost(int[][] costs) {
		if (costs == null || costs.length == 0) {
			return 0;
		}

		for (int i = 1; i < costs.length; i++) {
			costs[i][0] += Math.min(costs[i - 1][1], costs[i - 1][2]);
			costs[i][1] += Math.min(costs[i - 1][0], costs[i - 1][2]);
			costs[i][2] += Math.min(costs[i - 1][0], costs[i - 1][1]);
		}

		int m = costs.length - 1;
		return Math.min(Math.min(costs[m][0], costs[m][1]), costs[m][2]);
	}

}
