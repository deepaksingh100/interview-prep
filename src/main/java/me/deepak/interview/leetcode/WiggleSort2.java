package me.deepak.interview.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
 * https://leetcode.com/problems/wiggle-sort-ii/
 * http://buttercola.blogspot.com/2016/01/leetcode-wiggle-sort-ii.html
 * https://leetcode.com/submissions/detail/236066165/
 * https://leetcode.com/submissions/detail/236093641/
*/
public class WiggleSort2 {

	public void wiggleSort(int[] a) {

		if (a == null || a.length <= 1) {
			return;
		}

		int[] temp = threeWayPartition(a);
		int n = a.length;
		int left = (n - 1) / 2;
		int right = n - 1;

		for (int i = 0; i < n; i++) {
			if ((i & 1) == 0) {
				a[i] = temp[left--];
			} else {
				a[i] = temp[right--];
			}
		}
	}

	private int[] threeWayPartition(int[] a) {
		int median = getMedian(a);
		int n = a.length;
		int left = 0;
		int right = n - 1;
		int[] temp = new int[n];
		for (int i = 0; i < n; i++) {
			if (a[i] < a[median]) {
				temp[left++] = a[i];
			} else if (a[i] > a[median]) {
				temp[right--] = a[i];
			}
		}

		for (int i = left; i <= right; i++) {
			temp[i] = a[median];
		}

		return temp;
	}

	private int getMedian(int[] a) {
		int n = a.length;
		PriorityQueue<int[]> minHeap = new PriorityQueue<>(n / 2,
				(int[] o1, int[] o2) -> Integer.compare(o1[1], o2[1]));
		for (int i = 0; i < n; i++) {
			minHeap.add(new int[] { i, a[i] });
			if (minHeap.size() > n / 2) {
				minHeap.remove();
			}
		}
		return minHeap.peek()[0];
	}

	public static void main(String[] args) {
		int[] a = new int[] { 1, 3, 2, 2, 3, 1 };
		new WiggleSort2().wiggleSort(a);
		System.out.println(Arrays.toString(a));
	}

}
