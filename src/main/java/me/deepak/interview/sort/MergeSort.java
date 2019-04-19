package me.deepak.interview.sort;

public class MergeSort {

	private MergeSort() {
	}

	public static void sort(int[] a, int start, int end) {
		if (start < end) {
			int mid = (start + end) >>> 1;
			sort(a, start, mid);
			sort(a, mid + 1, end);
			merge(a, start, mid, end);
		}
	}

	private static void merge(int[] a, int start, int mid, int end) {
		int leftHalfLength = mid - start + 1;
		int rightHalfLength = end - mid;
		int[] leftHalf = new int[leftHalfLength];
		int[] rightHalf = new int[rightHalfLength];
		System.arraycopy(a, start, leftHalf, 0, leftHalfLength);
		System.arraycopy(a, start + leftHalfLength, rightHalf, 0, rightHalfLength);
		int leftHalfIndex = 0;
		int rightHalfIndex = 0;
		int index = start;
		while (leftHalfIndex < leftHalfLength && rightHalfIndex < rightHalfLength) {
			if (leftHalf[leftHalfIndex] < rightHalf[rightHalfIndex]) {
				a[index++] = leftHalf[leftHalfIndex++];
			} else {
				a[index++] = rightHalf[rightHalfIndex++];
			}
		}
		while (leftHalfIndex < leftHalfLength) {
			a[index++] = leftHalf[leftHalfIndex++];
		}
		while (rightHalfIndex < rightHalfLength) {
			a[index++] = rightHalf[rightHalfIndex++];
		}
	}
}
