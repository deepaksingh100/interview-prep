package me.deepak.interview.bits;

/*
 * https://www.geeksforgeeks.org/find-the-two-numbers-with-odd-occurences-in-an-unsorted-array/
 * https://www.geeksforgeeks.org/find-two-non-repeating-elements-in-an-array-of-repeating-elements/
 * https://stackoverflow.com/questions/22952651/explain-using-xor-to-find-two-non-duplicate-integers-in-an-array/22953668#22953668
*/
public class TwoNumbersWithOddOccurrencesInUnsortedArray {

	private TwoNumbersWithOddOccurrencesInUnsortedArray() {
	}

	/*
	 * Prints two numbers that occur odd number of times. The function assumes that
	 * the array length is at least 2 and there are exactly two numbers occurring
	 * odd number of times.
	 */
	public static int[] getOddOccurrences(int[] arr) {

		int length = arr.length;

		// will hold XOR of two odd occurring elements
		int xor = 0;

		/*
		 * get the XOR of all elements in arr[]. The xor will basically be XOR of two
		 * odd occurring elements.
		 */
		for (int i = 0; i < length; i++) {
			xor ^= arr[i];
		}

		/*
		 * get one set bit in the xor. We get rightmost set bit in the following line as
		 * it is easy to get.
		 */
		int rightMostSetBitNumber = xor & -xor;

		// two odd occurring elements
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

		return new int[] { x, y };
	}

}
