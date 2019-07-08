package me.deepak.interview.geeksforgeeks;

/*
 * https://www.geeksforgeeks.org/majority-element/
*/
public class MajorityNumber {

	private MajorityNumber() {
	}

	public static int majorityNumber(int[] a, int n) {
		int majorityIndex = 0;
		int count = 1;
		for (int i = 1; i < n; i++) {
			if (a[majorityIndex] == a[i]) {
				count++;
			} else {
				count--;
			}
			if (count == 0) {
				majorityIndex = i;
				count = 1;
			}
		}
		return isMajorityNumber(a, n, a[majorityIndex]) ? a[majorityIndex] : -1;
	}

	private static boolean isMajorityNumber(int[] a, int n, int majorityNumber) {
		int count = 0;
		for (int i = 0; i < n; i++) {
			if (a[i] == majorityNumber) {
				count++;
			}
		}
		return count > n / 2;
	}

}
