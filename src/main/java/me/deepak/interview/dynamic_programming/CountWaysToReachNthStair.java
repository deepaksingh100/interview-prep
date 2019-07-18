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
	 * 
	 */
	public static int count(int n, int m) {

		int[] table = new int[n + 1];
		table[0] = 1;
		table[1] = 1;
		for (int i = 2; i < n; i++) {
			for (int j = 1; j <= m && j <= i; j++) {
				table[i] += table[i - j];
			}
		}
		return table[n];
	}

}
