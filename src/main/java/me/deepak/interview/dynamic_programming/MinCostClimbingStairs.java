package me.deepak.interview.dynamic_programming;

/*
 * https://leetcode.com/problems/min-cost-climbing-stairs/
*/
public class MinCostClimbingStairs {

	public int minCostClimbingStairs(int[] cost) {
		if (cost == null || cost.length == 0) {
			return 0;
		}
		int n = cost.length;
		int[] minCost = new int[n + 1];
		minCost[0] = 0;
		minCost[1] = 0;
		for (int i = 2; i <= n; i++) {
			minCost[i] = Math.min(minCost[i - 1] + cost[i - 1], minCost[i - 2] + cost[i - 2]);
		}
		return minCost[n];
	}

	public int minCostClimbingStairs2(int[] cost) {
		if (cost == null || cost.length == 0) {
			return 0;
		}
		int n = cost.length;
		int minCost1 = 0;
		int minCost2 = 0;
		for (int i = 2; i <= n; i++) {
			int temp = Math.min(minCost1 + cost[i - 1], minCost2 + cost[i - 2]);
			minCost2 = minCost1;
			minCost1 = temp;
		}
		return minCost1;
	}

}
