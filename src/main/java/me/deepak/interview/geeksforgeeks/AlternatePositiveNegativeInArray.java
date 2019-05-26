package me.deepak.interview.geeksforgeeks;

import static me.deepak.interview.bits.Even.isEven;
import static me.deepak.interview.sort.utils.SwapUtil.swap;

/*
 * https://www.geeksforgeeks.org/rearrange-array-in-alternating-positive-negative-items-with-o1-extra-space-set-2/
*/
public class AlternatePositiveNegativeInArray {

	private AlternatePositiveNegativeInArray() {
	}

	// this method maintains original order of elements
	public static void alternatePositiveNegative(int[] a, int n) {

		// count of +ve numbers
		int pCount = 0;
		for (int i = 0; i < n; i++) {
			if (a[i] >= 0) {
				pCount++;
			}
		}

		// count of -ve numbers
		int nCount = n - pCount;

		int i = 0;
		int j = 1;
		while (pCount > 0 && nCount > 0) {

			if ((isEven(i) && a[i] >= 0) || (!isEven(i) && a[i] < 0)) {

				// valid case
				if (a[i] >= 0) {
					pCount--;
				} else {
					nCount--;
				}
				i++;
				j = i + 1;
			} else if (((isEven(i) && a[i] < 0) || (!isEven(i) && a[i] >= 0)) && j < n) {

				// invalid case
				swap(a, i, j);
				j++;
			}
		}
	}

	// method to rearrange positive and negative integers in alternate fashion. The
	// below solution doesn't maintain original order of elements
	public static void alternatePositiveNegative2(int[] arr, int n) {
		int i = -1;
		int j = n;

		// shift all negative values to the end
		while (i < j) {
			while (arr[i++] >= 0)
				;
			while (arr[j--] < 0)
				;
			if (i < j) {
				swap(arr, i, j);
			}
		}

		// i has index of leftmost negative element
		if (i == 0 || i == n) {
			return;
		}

		// start with first positive element at index 0

		// Rearrange array in alternating positive &
		// negative items
		int k = 0;

		while (k < n && i < n) {

			// swap next positive element at even position
			// from next negative element.
			swap(arr, k, i);
			i = i + 1;
			k = k + 2;
		}
	}

}
