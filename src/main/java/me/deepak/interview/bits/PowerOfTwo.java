package me.deepak.interview.bits;

/*
 * https://leetcode.com/problems/power-of-two/
 * https://www.geeksforgeeks.org/program-to-find-whether-a-no-is-power-of-two/
*/
public class PowerOfTwo {

	private PowerOfTwo() {
	}

	public static boolean isPowerOfTwo(int n) {
		return n > 0 && (n & (n - 1)) == 0;
	}

}
