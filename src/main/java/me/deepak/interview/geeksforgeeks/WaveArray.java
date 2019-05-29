package me.deepak.interview.geeksforgeeks;

import static me.deepak.interview.sort.utils.SwapUtil.swap;

/*
 * https://www.geeksforgeeks.org/sort-array-wave-form-2/
*/
public class WaveArray {

	private WaveArray() {
	}

	public static void waveArray(int[] a, int n) {

		// traverse all even elements
		for (int i = 0; i < n; i += 2) {

			// if current even element is smaller than previous
			if (i > 0 && a[i] < a[i - 1]) {
				swap(a, i, i - 1);
			}

			// if current even element is smaller than next
			if (i < n - 1 && a[i] < a[i + 1]) {
				swap(a, i, i + 1);
			}
		}
	}

}
