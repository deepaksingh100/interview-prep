package me.deepak.interview.sort;

/*
 * https://www.geeksforgeeks.org/counting-sort/
*/
public final class CountingSort {

	private CountingSort() {
	}

	public static int[] sort(int[] a, int maxElement) {

		// count[i] holds the count of numbers less than or equals to i in a[]
		int[] count = new int[maxElement + 1];

		// filling count[] with count of number i at count[i]
		for (int i = 0; i < a.length; i++) {
			count[a[i]]++;
		}

		// filling count[i] with the count of numbers less than or equals to i in a[]
		for (int i = 1; i < count.length; i++) {
			count[i] += count[i - 1];
		}

		// holds the sorted elements
		int[] sorted = new int[a.length];

		// count[a[i]] - 1 must be index of a[i] in sorted[]
		for (int i = a.length - 1; i >= 0; i--) {
			sorted[--count[a[i]]] = a[i];
		}
		return sorted;
	}

}
