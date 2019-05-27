package me.deepak.interview.dynamic_programming;

import java.util.ArrayList;
import java.util.List;

/*
 * https://www.geeksforgeeks.org/cutting-a-rod-dp-13/
*/

public class RodCutting {

	private RodCutting() {
	}

	public static int cutRod(int[] prices, int rodLength) {

		// revenues[i] represents the max revenue for rod length i
		int[] revenues = new int[rodLength + 1];

		// max revenue from 0 length rod is 0, starting from rod length 1
		for (int i = 1; i <= rodLength; i++) {
			int maxRevenue = Integer.MIN_VALUE;

			// cutting rod of length i into j and i - j - 1 (0 -> n - 1)
			for (int j = 0; j < i; j++) {

				// cutRod(n) = for all i in {0, 1 .. n-1} max(price[i] + cutRod(n-i-1))
				maxRevenue = Math.max(maxRevenue, prices[j] + revenues[i - j - 1]);
			}
			revenues[i] = maxRevenue;
		}
		return revenues[rodLength];
	}

	public static List<Integer> cutRodSolution(int[] prices, int rodLength) {

		// revenues[i] represents the max revenue for rod length i
		int[] revenues = new int[rodLength + 1];
		int[] solution = new int[rodLength + 1];

		// max revenue from zero length rod is zero, Starting from rod length 1
		for (int i = 1; i <= rodLength; i++) {
			int maxRevenue = Integer.MIN_VALUE;

			// cutting rod of length i into j and i - j - 1 (0 -> n - 1)
			for (int j = 0; j < i; j++) {

				// cutRod(n) = for all i in {0, 1 .. n-1} max(price[i] + cutRod(n-i-1))
				if (maxRevenue < prices[j] + revenues[i - j - 1]) {
					maxRevenue = prices[j] + revenues[i - j - 1];

					// hold the optimal size j of the first piece to cut off when solving a
					// subproblem of size i
					solution[i] = j;
				}
			}
			revenues[i] = maxRevenue;
		}
		
		List<Integer> cutRod = new ArrayList<>();
		while (rodLength > 0) {

			// adding optimal values to answer
			cutRod.add(solution[rodLength]);
			rodLength -= solution[rodLength];
		}
		return cutRod;
	}

}
