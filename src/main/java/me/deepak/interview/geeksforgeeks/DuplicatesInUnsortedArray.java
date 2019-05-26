package me.deepak.interview.geeksforgeeks;

import java.util.ArrayList;
import java.util.List;

public class DuplicatesInUnsortedArray {

	private DuplicatesInUnsortedArray() {
	}

	public static List<Integer> getDuplicates(int[] a) {

		int n = a.length;

		// First check all the values that are present in an array then go to that
		// values as indexes and increment by the size of array
		for (int i = 0; i < n; i++) {
			a[a[i] % n] += n;
		}

		List<Integer> duplicates = new ArrayList<>();

		// Now check which value exists more than once by dividing with the size of
		// array
		for (int i = 0; i < n; i++) {
			if (a[i] / n > 1) {
				duplicates.add(i);
			}
		}
		return duplicates;
	}

}
