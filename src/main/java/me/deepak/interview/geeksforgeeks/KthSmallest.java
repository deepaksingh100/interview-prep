package me.deepak.interview.geeksforgeeks;

import static me.deepak.interview.sort.utils.RandomizedPartitionUtil.randomizedPartition;

/*
 * https://www.geeksforgeeks.org/kth-smallestlargest-element-unsorted-array/
 * https://www.geeksforgeeks.org/kth-smallestlargest-element-unsorted-array-set-2-expected-linear-time/
*/
public final class KthSmallest {

	private KthSmallest() {
	}

	public static int getKthSmallest(int[] a, int start, int end, int k) {

		// base case, only one element
		if (start == end) {
			return a[start];
		}

		// get pivot index
		int pivotIndex = randomizedPartition(a, start, end);

		// l is number of elements in the left side a[start...pivotIndex-1] of the
		// partition, plus one for the pivot element.
		int l = pivotIndex - start + 1;

		if (k == l) {

			// answer is at pivot index
			return a[pivotIndex];
		} else if (k < l) {

			// answer is in left side
			return getKthSmallest(a, start, pivotIndex - 1, k);
		}

		// answer is in right side
		return getKthSmallest(a, pivotIndex + 1, end, k - l);
	}

}
