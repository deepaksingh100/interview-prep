package me.deepak.interview.dynamic_programming;

/*
 * https://www.geeksforgeeks.org/count-ways-reach-nth-stair/
*/
public class CountWaysToReachNthStair {

	private CountWaysToReachNthStair() {
	}

	/*
	 * How to count number of ways if the person can climb up to m stairs for a
	 * given value m & have to go to nth stair?
	 * 
	 * We can write the recurrence as: ways(n, m) = ways(n-1, m) + ways(n-2, m) +
	 * ... ways(n-m, m)
	 */
	public static long count(int n, int m) {

		// base case
		if (m == 1) {
			return 1;
		}

		// stepCounts[i] will be the ans for ith stair
		long[] stepCounts = new long[n + 1];

		// base cases
		stepCounts[0] = 1;
		stepCounts[1] = 1;

		// populating stepCounts[0...m] as sum of all previous values
		long sum = stepCounts[0] + stepCounts[1];
		for (int i = 2; i <= m; i++) {
			stepCounts[i] = sum;
			sum += stepCounts[i];
		}

		// sliding window of length m. stepCounts[i - 1] will have sum of previous m - 1
		// elements. Thus sum of m length window ending on i - 1 is stepCounts[i - 1] *
		// 2. To calculate sum of m length window ending on i we need to subtract
		// stepCounts[i - m - 1] from stepCounts[i - 1] * 2.
		for (int i = m + 1; i <= n; i++) {
			stepCounts[i] = stepCounts[i - 1] * 2 - stepCounts[i - m - 1];
		}

		// return final response
		return stepCounts[n];
	}

	public static void main(String[] args) {
		for (int i = 1; i <= 10; i++) {
			System.out.println("m = " + i + ", ways = " + count(10, i));
		}
	}

}
