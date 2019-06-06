package me.deepak.interview.leetcode;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/candy/
 * https://leetcode.com/articles/candy/
 * http://web.archive.org/web/20170820045023/http://stackandqueue.com:80/?p=108
*/
public class Candy {

	public int candy(int[] a) {

		int n = a.length;
		int[] candies = new int[n];
		Arrays.fill(candies, 1);

		for (int i = 1; i < n; i++) {
			if (a[i] > a[i - 1]) {
				candies[i] = candies[i - 1] + 1;
			}
		}

		for (int i = n - 2; i >= 0; i--) {
			if (a[i] > a[i + 1]) {
				candies[i] = Math.max(candies[i], candies[i + 1] + 1);
			}
		}

		return Arrays.stream(candies).sum();

	}

}
