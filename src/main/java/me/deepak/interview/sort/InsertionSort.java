package me.deepak.interview.sort;

public final class InsertionSort {

	private InsertionSort() {
	}
	
	public static void sort(int[] a) {
		for (int i = 1; i < a.length; i++) {
			int hole = i;
			int value = a[hole];
			while (hole > 0 && value < a[hole - 1]) {
				a[hole] = a[hole - 1];
				hole--;
			}
			a[hole] = value;
		}
	}

}
