package me.deepak.interview.dynamic_programming;

/*
 * https://www.geeksforgeeks.org/dice-throw-dp-30/
 * https://www.techiedelight.com/total-ways-sum-with-n-throws-dice-having-k-faces/
*/
public class DiceThrow {

	private DiceThrow() {
	}

	public static long countWays(int dice, int face, int sum) {
		long[][] lookup = new long[dice + 1][sum + 1];
		return countWays(dice, face, sum, lookup);
	}

	private static long countWays(int dice, int face, int sum, long[][] lookup) {

		// if desired sum is reached with dice dices
		if (dice == 0) {
			return (sum == 0) ? 1 : 0;
		}

		// desired sum can't be reached with current configuration
		if (sum < dice || face * dice < sum) {
			return 0;
		}

		// if sub-problem is seen for the first time, solve it and
		// store its result in an array or map
		if (lookup[dice][sum] == 0) {

			// recur for all possible solutions
			for (int i = 1; i <= face; i++) {
				lookup[dice][sum] += countWays(dice - 1, face, sum - i, lookup);
			}
		}

		// return solution to current sub-problem
		return lookup[dice][sum];
	}
}
