package me.deepak.interview.leetcode;

import static me.deepak.interview.sort.utils.SwapUtil.swap;

/*
 * https://leetfree.com/problems/wiggle-sort.html
 * https://www.geeksforgeeks.org/sort-array-wave-form-2/
*/
public class WiggleSort {

	public void wiggleSort(int[] a) {

		int n = a.length;

		// traverse all odd elements
		for (int i = 1; i < n; i += 2) {

			// if current odd element is smaller than previous
			if (a[i] < a[i - 1]) {
				swap(a, i, i - 1);
			}

			// if current odd element is smaller than next
			if (i < n - 1 && a[i] < a[i + 1]) {
				swap(a, i, i + 1);
			}
		}
	}

}
