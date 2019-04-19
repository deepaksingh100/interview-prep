package me.deepak.interview.randomized_select;

import static me.deepak.interview.sort.utils.RandomizedPartitionUtil.randomizedPartition;

public final class RandomizedSelect {

	private RandomizedSelect() {
	}

	public static int getkthSmallest(int[] a, int start, int end, int k) {
		if (start == end) {
			return a[start];
		}
		int pivotIndex = randomizedPartition(a, start, end);
		int leftHalfLength = pivotIndex - start + 1;
		if (k == leftHalfLength) {
			return a[pivotIndex];
		} else if (k < leftHalfLength) {
			return getkthSmallest(a, start, pivotIndex - 1, k);
		} else {
			return getkthSmallest(a, pivotIndex + 1, end, k - leftHalfLength);
		}
	}

}
