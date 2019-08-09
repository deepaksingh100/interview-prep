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

			// cutting rod of length i into j and i - j
			for (int j = 1; j <= i; j++) {

				// cutRod(i) = for all j in {1 .. i} max(price[j - 1] + cutRod(i - j))
				maxRevenue = Math.max(maxRevenue, prices[j - 1] + revenues[i - j]);
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

			// cutting rod of length i into j and i - j
			for (int j = 1; j <= i; j++) {

				// cutRod(i) = for all j in {1 .. i} max(price[j - 1] + cutRod(i - j))
				if (maxRevenue < prices[j - 1] + revenues[i - j]) {
					maxRevenue = prices[j - 1] + revenues[i - j];

					// hold the optimal size j of the first piece to cut off when solving a
					// subproblem of size i
					solution[i] = j - 1;
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
