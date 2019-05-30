package me.deepak.interview.geeksforgeeks;

/*
 * https://www.geeksforgeeks.org/find-a-partition-point-in-array/
 * https://www.geeksforgeeks.org/find-the-element-before-which-all-the-elements-are-smaller-than-it-and-after-which-all-are-greater-than-it/
*/
public class PartitionPoint {

	private PartitionPoint() {
	}

	public static int getPoint(int[] a) {
		int n = a.length;

		// leftMax[i] stores maximum of arr[0..i-1]
		int[] leftMax = new int[n];
		leftMax[0] = a[0];
		for (int i = 1; i < n; i++) {
			leftMax[i] = Math.max(leftMax[i - 1], a[i - 1]);
		}

		int rightMin = a[n - 1];

		// traverse array from right
		for (int i = n - 2; i >= 0; i--) {

			// update right minimum
			rightMin = Math.min(rightMin, a[i - 1]);

			// check if we found a required element
			if (leftMax[i] < a[i] && a[i] < rightMin) {
				return a[i];
			}
		}

		// if there was no element matching criteria
		return -1;

	}

}
