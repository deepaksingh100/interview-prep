package me.deepak.interview.dynamic_programming;

/*
 * https://leetcode.com/problems/climbing-stairs/
 * https://leetcode.com/articles/climbing-stairs/
 * https://www.youtube.com/watch?v=NFJ3m9a1oJQ
*/

public class ClimbingStairs {

	public int climbStairs(int n) {
		int first = 1;
		int second = 1;
		for (int i = 2; i <= n; i++) {
			int temp = first + second;
			first = second;
			second = temp;
		}
		return second;
	}
}
