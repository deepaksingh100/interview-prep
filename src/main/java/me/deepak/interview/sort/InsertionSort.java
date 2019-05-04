package me.deepak.interview.sort;

/*
 * https://youtu.be/i-SKeOcBwko
*/
public final class InsertionSort {

	private InsertionSort() {
	}

	public static void sort(int[] a) {

		// a[0] is sorted ... trivially
		for (int i = 1; i < a.length; i++) {

			// create a hole at i
			int hole = i;
			int holeValue = a[hole];

			// while hole > 0 && holeValue < a[hole - 1], shift hole to hole - 1
			while (hole > 0 && holeValue < a[hole - 1]) {
				a[hole] = a[hole - 1];
				hole--;
			}

			// put hole's value in final hole
			a[hole] = holeValue;
		}
	}

}
