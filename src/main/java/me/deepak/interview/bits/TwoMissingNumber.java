package me.deepak.interview.bits;

/*
 * https://www.geeksforgeeks.org/find-two-missing-numbers-set-2-xor-based-solution/
*/
public class TwoMissingNumber {

	private TwoMissingNumber() {
	}

	/*
	 * Function to find two missing numbers in range [1, n]. This function assumes
	 * that size of array is n-2 and all array elements are distinct. From 1 to n
	 * numbers are present arr[]
	 */
	public static int[] findTwoMissingNumbers(int[] arr, int n) {

		int length = arr.length;

		// will hold xor of two odd occurring elements
		int xor = 0;

		/*
		 * get the XOR of all elements in arr[] & all possible elements. The xor will
		 * basically be XOR of two even occurring elements. By second loop we are
		 * ensuring that even occurring elements get XORed odd times.
		 */
		for (int i = 0; i < length; i++) {
			xor ^= arr[i];
		}

		for (int i = 1; i <= n; i++) {
			xor ^= i;
		}

		/*
		 * get one set bit in the xor. We get rightmost set bit in the following line as
		 * it is easy to get.
		 */
		int rightMostSetBitNumber = xor & -xor;

		// two missing elements
		int x = 0;
		int y = 0;

		/*
		 * Now divide elements in two sets:
		 * 
		 * 1) The elements having the corresponding bit as 1.
		 * 
		 * 2) The elements having the corresponding bit as 0.
		 */
		for (int i = 0; i < length; i++) {

			if ((arr[i] & rightMostSetBitNumber) == 0) {

				// XOR of first set in arr[]
				x ^= arr[i];
			} else {

				// XOR of second set in arr[]
				y ^= arr[i];
			}
		}

		for (int i = 1; i <= n; i++) {

			if ((i & rightMostSetBitNumber) == 0) {

				// XOR of first set in arr[] and {1, 2, ...n }
				x ^= i;
			} else {

				// XOR of second set in arr[] and {1, 2, ...n }
				y ^= i;
			}
		}

		return new int[] { x, y };
	}

}
