package me.deepak.interview.sort;

import static me.deepak.interview.sort.utils.SwapUtil.swap;

public final class BubbleSort {
	
	private BubbleSort() {
	}

	public static void sort(int[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			boolean isSorted = true;
			for (int j = 0; j < a.length - i - 1; j++) {
				if (a[j] > a[j + 1]) {
					isSorted = false;
					swap(a, j, j + 1);
				}
			}
			if (isSorted) {
				break;
			}
		}
	}

}
