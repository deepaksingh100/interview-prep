package me.deepak.interview.leetcode;

/*
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
*/
public class TwoSum2 {

	public int[] twoSum(int[] numbers, int target) {
		int length = numbers.length;
		int i = 0;
		int j = length - 1;
		while (i < j) {
			if (numbers[i] + numbers[j] < target) {
				i++;
			} else if (numbers[i] + numbers[j] > target) {
				j--;
			} else {
				break;
			}
		}
		return new int[] { i + 1, j + 1 };
	}

}
