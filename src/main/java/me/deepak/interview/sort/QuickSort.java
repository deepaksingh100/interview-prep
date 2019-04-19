package me.deepak.interview.sort;

import me.deepak.interview.randomized_select.partition.RandomizedPartition;

public class QuickSort {

	public void sort(int[] a, int start, int end) {
		if (start < end) {
			int pivotIndex = new RandomizedPartition().randomizedPartition(a, start, end);
			sort(a, start, pivotIndex - 1);
			sort(a, pivotIndex + 1, end);
		}
	}

}
