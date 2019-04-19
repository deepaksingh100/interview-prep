package me.deepak.interview.sort;

import static me.deepak.interview.sort.utils.SwapUtil.swap;

public class SelectionSort {

	public void sort(int[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < a.length; j++) {
				if (a[minIndex] > a[j]) {
					minIndex = j;
				}
			}
			if (minIndex != i) {
				swap(a, i, minIndex);
			}
		}
	}

}
