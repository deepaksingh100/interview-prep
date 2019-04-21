package me.deepak.interview.leetcode;

/*
 * https://leetcode.com/problems/house-robber/
*/

public class HouseRobber {

	public int rob(int[] a) {
		if (a == null || a.length < 1) {
			return 0;
		}
		int incl = a[0];
		int excl = 0;
		for (int i = 1; i < a.length; i++) {
			int exclNew = Math.max(incl, excl);
			incl = excl + a[i];
			excl = exclNew;
		}
		return Math.max(incl, excl);
	}

}
