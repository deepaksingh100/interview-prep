package me.deepak.interview.bits;

/*
 * https://www.geeksforgeeks.org/find-the-two-repeating-elements-in-a-given-array/
 * https://stackoverflow.com/questions/22952651/explain-using-xor-to-find-two-non-duplicate-integers-in-an-array/22953668#22953668
*/
public class TwoNumbersWithEvenOccurrencesInUnsortedArray {

	private TwoNumbersWithEvenOccurrencesInUnsortedArray() {
	}

	/*
	 * Prints two numbers that occur even number of times.
	 */
	public static int[] getEvenOccurrences(int[] arr) {

		int length = arr.length;

		// from 1 to n numbers are present arr[]
		int n = length - 2;

		// will hold XOR of two odd occurring elements
		int xor = 0;

		/*
		 * get the XOR of all elements in arr[] & all possible elements. The xor will
		 * basically be XOR of two even occurring elements. By second loop we are
		 * ensuring that even occurring elements get XORed odd times.
		 */
		for (int i = 0; i < length; i++) {
			xor ^= arr[i];
		}

		for (int i = 1; i <= length; i++) {
			xor ^= i;
		}

		/*
		 * get one set bit in the xor. We get rightmost set bit in the following line as
		 * it is easy to get.
		 */
		int rightMostSetBitNumber = xor & -xor;

		// two even occurring elements
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
