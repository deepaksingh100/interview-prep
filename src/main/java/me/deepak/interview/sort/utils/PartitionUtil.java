package me.deepak.interview.sort.utils;

import static me.deepak.interview.sort.utils.SwapUtil.swap;

public final class PartitionUtil {

	private PartitionUtil() {
	}

	public static int partition(int[] a, int start, int end) {

		// select last element as pivot
		int pivot = a[end];

		// elements left to this index are less than or equals to pivot value
		int currentPivotIndex = start;

		// consider elements in range [start, end)
		for (int i = start; i < end; i++) {

			// if a[i] <= pivot value, swap a[i] with a[currentPivotIndex], increase
			// currentPivotIndex by 1
			if (a[i] <= pivot) {
				swap(a, i, currentPivotIndex);
				currentPivotIndex++;
			}
		}

		// finally swap a[end] with a[currentPivotIndex]
		swap(a, end, currentPivotIndex);

		return currentPivotIndex;
	}

}
