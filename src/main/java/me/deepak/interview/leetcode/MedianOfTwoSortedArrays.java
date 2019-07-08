package me.deepak.interview.leetcode;

/*
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 * https://leetcode.com/problems/median-of-two-sorted-arrays/discuss/2481/Share-my-O(log(min(mn))-solution-with-explanation
 * https://github.com/mission-peace/interview/blob/master/src/com/interview/binarysearch/MedianOfTwoSortedArrayOfDifferentLength.java
*/
public class MedianOfTwoSortedArrays {

	public double findMedianSortedArrays(int[] a1, int[] a2) {

		// if a1 length is greater than switch them so that a1 is smaller than a2.
		if (a1.length > a2.length) {
			return findMedianSortedArrays(a2, a1);
		}

		int n1 = a1.length;
		int n2 = a2.length;

		int low = 0;
		int high = n1;

		while (low <= high) {

			int partition1 = (low + high) >>> 1;
			int partition2 = ((n1 + n2 + 1) >>> 1) - partition1;

			// if partition1 is 0 it means nothing is there on left side. Use -INF for
			// left1
			// if partition1 is length of input then there is nothing on right side. Use
			// +INF for right1
			int left1 = (partition1 == 0) ? Integer.MIN_VALUE : a1[partition1 - 1];
			int right1 = (partition1 == n1) ? Integer.MAX_VALUE : a1[partition1];

			int left2 = (partition2 == 0) ? Integer.MIN_VALUE : a2[partition2 - 1];
			int right2 = (partition2 == n2) ? Integer.MAX_VALUE : a2[partition2];

			if (left1 <= right2 && left2 <= right1) {

				// We have partitioned array at correct place
				// Now get max of left elements and min of right elements to get the median in
				// case of even length combined array size
				// or get max of left for odd length combined array size.
				if (((n1 + n2) & 1) == 0) {
					return (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
				}
				return Math.max(left1, left2);
			} else if (left1 > right2) { // we are too far on right side for partition1. Go on left side.
				high = partition1 - 1;
			} else { // we are too far on left side for partition1. Go on right side.
				low = partition1 + 1;
			}
		}

		// Only we we can come here is if input arrays were not sorted. Throw in that
		// scenario.
		throw new IllegalArgumentException();
	}

}
