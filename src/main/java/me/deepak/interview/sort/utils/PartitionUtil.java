package me.deepak.interview.sort.utils;

import static me.deepak.interview.sort.utils.SwapUtil.swap;

public final class PartitionUtil {

	private PartitionUtil() {
	}

	public static int partition(int[] a, int start, int end) {
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
