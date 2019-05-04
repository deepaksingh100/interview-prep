package me.deepak.interview.sort;

import static me.deepak.interview.sort.utils.SwapUtil.swap;

/*
 * https://youtu.be/Jdtq5uKz-w4
*/
public final class BubbleSort {

	private BubbleSort() {
	}

	// right se sorting hogi
	public static void sort(int[] a) {

		for (int i = 0; i < a.length - 1; i++) {
			boolean sorted = true;
			for (int j = 0; j < a.length - i - 1; j++) {

				// if elements are in wrong order, swap.
				if (a[j] > a[j + 1]) {
					sorted = false;
					swap(a, j, j + 1);
				}
			}

			// if array is already sorted, break.
			if (sorted) {
				break;
			}
		}
	}

}
