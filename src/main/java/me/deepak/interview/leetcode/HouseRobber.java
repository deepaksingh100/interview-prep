package me.deepak.interview.leetcode;

/*
 * https://leetcode.com/problems/house-robber/
 * https://www.geeksforgeeks.org/maximum-sum-such-that-no-two-elements-are-adjacent/
*/
public class HouseRobber {

	public int rob(int[] a) {
		if (a == null || a.length < 1) {
			return 0;
		}

		// max sum excluding the previous element
		int excl = 0;

		// max sum including the previous element
		int incl = a[0];

		for (int i = 1; i < a.length; i++) {

			// max sum excluding the current element will be max(incl, excl)
			int exclNew = Math.max(incl, excl);

			// max sum including the current element will be excl + current element
			incl = excl + a[i];

			excl = exclNew;
		}
		return Math.max(incl, excl);
	}

}
