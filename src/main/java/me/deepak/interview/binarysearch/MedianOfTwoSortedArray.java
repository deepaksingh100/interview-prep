package me.deepak.interview.binarysearch;

import static me.deepak.interview.bits.Even.isEven;

/*
 * https://algorithms.tutorialhorizon.com/find-median-of-two-sorted-arrays-of-same-size/
 * https://www.geeksforgeeks.org/median-of-two-sorted-arrays/
 * https://github.com/mission-peace/interview/blob/master/src/com/interview/binarysearch/MedianOfTwoSortedArray.java
*/
public class MedianOfTwoSortedArray {

	private MedianOfTwoSortedArray() {
	}

	/*
	 * This function returns median of a1[] and a2[]. Assumptions in this function:
	 * Both a1[] and a2[] are sorted arrays Both have n elements
	 */
	public static double median(int[] a1, int[] a2) {
		int n = a1.length;
		return median(a1, 0, n - 1, a2, 0, n - 1);
	}

	private static double median(int[] a1, int low1, int high1, int[] a2, int low2, int high2) {

		int n1 = high1 - low1 + 1;
		int n2 = high2 - low2 + 1;

		if (n1 == 2 && n2 == 2) {
			return (Math.max(a1[low1], a2[low2]) + Math.min(a1[high1], a2[high2])) / 2.0;
		}

		double median1 = median(a1, low1, high1);
		double median2 = median(a2, low2, high2);

		int mid1 = (low1 + high1) >>> 1;
		int mid2 = (low2 + high2) >>> 1;

		if (median1 > median2) {
			return median(a1, low1, mid1, a2, mid2, high2);
		}
		return median(a1, mid1, high1, a2, low2, mid2);
	}

	/*
	 * Function to get median of a sorted array
	 */
	private static double median(int[] arr, int low, int high) {
		int n = high - low + 1;
		return isEven(n) ? (arr[low + n / 2] + arr[low + n / 2 - 1]) / 2 : arr[low + n / 2];
	}
}
