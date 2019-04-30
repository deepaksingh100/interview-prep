package me.deepak.interview.dynamic_programming;

/*
 * https://leetcode.com/problems/house-robber/
 * https://stackoverflow.com/questions/39541824/leetcode-house-robber
*/

public class HouseRobber {

	private HouseRobber() {
	}

	public static int rob(int[] houseValues) {
		int length = houseValues.length;

		// maxRobbery[i] represents the maximum value robbed
		// so far after reaching house i.
		int[] maxRobbery = new int[length + 1];

		// if we rob zero house, then max robbery will be zero
		maxRobbery[0] = 0;

		// if we rob one house, then max robbery will be houseValues[0]
		maxRobbery[1] = houseValues[0];

		// Either rob current house or leave it
		for (int i = 2; i <= length; i++) {
			maxRobbery[i] = Math.max(houseValues[i - 1] + maxRobbery[i - 2] // Rob current house
					, maxRobbery[i - 1] // Do not rob current house
			);
		}
		return maxRobbery[length];
	}

}
