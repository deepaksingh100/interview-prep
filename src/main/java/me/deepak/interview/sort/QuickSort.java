package me.deepak.interview.sort;

import static me.deepak.interview.sort.utils.RandomizedPartitionUtil.randomizedPartition;

public final class QuickSort {

	private QuickSort() {
	}

	public static void sort(int[] a, int start, int end) {
		if (start < end) {
			int pivotIndex = randomizedPartition(a, start, end);
			sort(a, start, pivotIndex - 1);
			sort(a, pivotIndex + 1, end);
		}
	}

}
