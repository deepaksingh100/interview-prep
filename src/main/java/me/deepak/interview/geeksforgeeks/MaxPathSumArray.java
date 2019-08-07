package me.deepak.interview.geeksforgeeks;

/*
 * https://www.geeksforgeeks.org/maximum-sum-path-across-two-arrays/
*/
public class MaxPathSumArray {

	public int maxPathSum(int[] a1, int[] a2) {
		int n1 = a1.length;
		int n2 = a2.length;
		int i = 0;
		int j = 0;
		int result = 0;
		int sum1 = 0;
		int sum2 = 0;

		while (i < n1 && j < n2) {
			if (a1[i] < a2[j]) {
				sum1 += a1[i++];
			} else if (a1[i] > a2[j]) {
				sum2 += a2[j++];
			} else {
				result += Math.max(sum1, sum2) + a1[i++];
				j++;
				sum1 = 0;
				sum2 = 0;
			}
		}
		while (i < n1) {
			sum1 += a1[i++];
		}
		while (j < n2) {
			sum2 += a2[j++];
		}
		return result + Math.max(sum1, sum2);
	}

}
