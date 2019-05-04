package me.deepak.interview.sort;

import static me.deepak.interview.sort.utils.RandomizedPartitionUtil.randomizedPartition;

/*
 * https://youtu.be/COk73cpQbFQ
*/
public final class QuickSort {

	private QuickSort() {
	}

	public static void sort(int[] a, int start, int end) {
		if (start < end) {

			// get pivot index
			int pivotIndex = randomizedPartition(a, start, end);

			// sort left side elements of pivot
			sort(a, start, pivotIndex - 1);

			// sort right side elements of pivot
			sort(a, pivotIndex + 1, end);
		}
	}

}
