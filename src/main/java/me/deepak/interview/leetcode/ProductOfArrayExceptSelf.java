package me.deepak.interview.leetcode;

/*
 * https://leetcode.com/problems/product-of-array-except-self/
 * https://www.geeksforgeeks.org/a-product-array-puzzle/
*/
public class ProductOfArrayExceptSelf {

	public int[] productExceptSelf(int[] a) {
		if (a == null || a.length < 1) {
			return new int[0];
		}
		int n = a.length;
		int[] prod = new int[n];
		int temp = 1;
		for (int i = 0; i < n; i++) {
			prod[i] = temp;
			temp *= a[i];
		}
		temp = 1;
		for (int i = n - 1; i >= 0; i--) {
			prod[i] *= temp;
			temp *= a[i];
		}
		return prod;
	}

}
