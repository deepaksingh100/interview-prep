package me.deepak.interview.leetcode;

import java.util.Random;

/*
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
*/
public class KthLargestElement {

	private static final Random RANDOM_NUMBER_GENERATOR = new Random();

	public int findKthLargest(int[] nums, int k) {
		return findKthLargest(nums, k, 0, nums.length - 1);
	}

	private int findKthLargest(int[] nums, int k, int start, int end) {

		// base case, only one element
		if (start == end) {
			return nums[start];
		}

		// get pivot index
		int pivotIndex = randomizedPartition(nums, start, end);

		// l is number of elements in the left side a[start...pivotIndex-1] of the
		// partition, plus one for the pivot element.
		int l = pivotIndex - start + 1;

		if (k == l) {

			// answer is at pivot index
			return nums[pivotIndex];
		} else if (k < l) {

			// answer is in left side
			return findKthLargest(nums, k, start, pivotIndex - 1);
		}

		// answer is in right side
		return findKthLargest(nums, k - l, pivotIndex + 1, end);
	}

	private int randomizedPartition(int[] nums, int start, int end) {

		// random index is generated in range [start, end]
		int randomIndex = RANDOM_NUMBER_GENERATOR.nextInt(end - start + 1) + start;
		swap(nums, end, randomIndex);
		return partition(nums, start, end);
	}

	private int partition(int[] nums, int start, int end) {

		// select last element as pivot
		int pivot = nums[end];

		// elements left to this index are greater than or equals to pivot value
		int currentPivotIndex = start;

		// if nums[i] >= pivot value, swap nums[i] with nums[currentPivotIndex],
		// increase currentPivotIndex by 1
		for (int i = start; i < end; i++) {
			if (nums[i] >= pivot) {
				swap(nums, i, currentPivotIndex++);
			}
		}

		// finally swap nums[end] with nums[currentPivotIndex]
		swap(nums, end, currentPivotIndex);
		return currentPivotIndex;
	}

	private void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

}
