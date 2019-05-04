package me.deepak.interview.sort;

/*
 * https://youtu.be/TzeBrDU-JaY
*/
public final class MergeSort {

	private MergeSort() {
	}

	public static void sort(int[] a, int start, int end) {
		if (start < end) {
			int mid = (start + end) >>> 1;

			// sort left half
			sort(a, start, mid);

			// sort right half
			sort(a, mid + 1, end);

			// merge both halves
			merge(a, start, mid, end);
		}
	}

	private static void merge(int[] a, int start, int mid, int end) {

		// length of left half
		int leftLength = mid - start + 1;

		// length of right half
		int rightLength = end - mid;

		int[] leftHalf = new int[leftLength];
		int[] rightHalf = new int[rightLength];
		System.arraycopy(a, start, leftHalf, 0, leftLength);
		System.arraycopy(a, start + leftLength, rightHalf, 0, rightLength);

		// to iterate on left half
		int leftHalfIndex = 0;

		// to iterate on right half
		int rightHalfIndex = 0;

		// to iterate on final array
		int index = start;

		// while both halves have elements
		while (leftHalfIndex < leftLength && rightHalfIndex < rightLength) {
			if (leftHalf[leftHalfIndex] < rightHalf[rightHalfIndex]) {
				a[index++] = leftHalf[leftHalfIndex++];
			} else {
				a[index++] = rightHalf[rightHalfIndex++];
			}
		}

		// while left half has elements
		while (leftHalfIndex < leftLength) {
			a[index++] = leftHalf[leftHalfIndex++];
		}

		// while right half has elements
		while (rightHalfIndex < rightLength) {
			a[index++] = rightHalf[rightHalfIndex++];
		}
	}
}
