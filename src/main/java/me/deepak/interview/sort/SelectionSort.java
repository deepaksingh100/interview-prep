package me.deepak.interview.sort;

import static me.deepak.interview.sort.utils.SwapUtil.swap;

/*
 * https://youtu.be/GUDLRan2DWM
*/
public final class SelectionSort {

	private SelectionSort() {
	}

	// left se sorting hogi
	public static void sort(int[] a) {

		for (int i = 0; i < a.length - 1; i++) {

			// index of min element
			int minIndex = i;

			for (int j = i + 1; j < a.length; j++) {
				if (a[minIndex] > a[j]) {

					// found new min, update minIndex
					minIndex = j;
				}
			}

			// if new min found, swap i & minIndex
			if (minIndex != i) {
				swap(a, i, minIndex);
			}
		}
	}

}
