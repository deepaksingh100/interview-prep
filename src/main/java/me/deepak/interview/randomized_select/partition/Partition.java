package me.deepak.interview.randomized_select.partition;

import static me.deepak.interview.sort.utils.SwapUtil.swap;

public class Partition {

	public int partition(int[] a, int start, int end) {
		int pivot = a[end];
		int currentPivotIndex = start;
		for (int i = start; i < end; i++) {
			if (a[i] <= pivot) {
				swap(a, i, currentPivotIndex);
				currentPivotIndex++;
			}
		}
		swap(a, end, currentPivotIndex);
		return currentPivotIndex;
	}

}
