package me.deepak.interview.sort;

public class CountingSort {

	public int[] sort(int[] a, int maxElement) {
		int[] count = new int[maxElement + 1];
		for (int i = 0; i < a.length; i++) {
			count[a[i]]++;
		}
		for (int i = 1; i < count.length; i++) {
			count[i] += count[i - 1];
		}
		int[] sorted = new int[a.length];
		for (int i = a.length - 1; i >= 0; i--) {
			sorted[--count[a[i]]] = a[i];
		}
		return sorted;
	}

}
