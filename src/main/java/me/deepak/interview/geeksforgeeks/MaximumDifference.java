package me.deepak.interview.geeksforgeeks;

/*
 * https://www.geeksforgeeks.org/maximum-difference-between-two-elements/
*/
public class MaximumDifference {

	private MaximumDifference() {
	}

	public static int maxDiff(int[] a) {
		int maxDiff = a[1] - a[0];
		int minElement = a[0];

		for (int i = 1; i < a.length; i++) {
			maxDiff = Math.max(maxDiff, a[i] - minElement);
			minElement = Math.min(minElement, a[i]);
		}

		return maxDiff;
	}

}
