package me.deepak.interview.dynamic_programming;

import java.util.ArrayList;
import java.util.List;

public class RodCutting {

	public static int cutRod(int[] prices, int rodLength) {
		int[] revenues = new int[rodLength + 1];
		for (int i = 1; i <= rodLength; i++) {
			int maxRevenue = Integer.MIN_VALUE;
			for (int j = 0; j < i; j++) {
				maxRevenue = Math.max(maxRevenue, prices[j] + revenues[i - j - 1]);
			}
			revenues[i] = maxRevenue;
		}
		return revenues[rodLength];
	}

	public static List<Integer> cutRodSolution(int[] prices, int rodLength) {
		int[] revenues = new int[rodLength + 1];
		int[] solution = new int[rodLength + 1];
		for (int i = 1; i <= rodLength; i++) {
			int maxRevenue = Integer.MIN_VALUE;
			for (int j = 0; j < i; j++) {
				if (maxRevenue < prices[j] + revenues[i - j - 1]) {
					maxRevenue = prices[j] + revenues[i - j - 1];
					solution[i] = j;
				}
			}
			revenues[i] = maxRevenue;
		}
		List<Integer> cutRod = new ArrayList<>();
		while (rodLength > 0) {
			cutRod.add(solution[rodLength]);
			rodLength -= solution[rodLength];
		}
		return cutRod;
	}

}
